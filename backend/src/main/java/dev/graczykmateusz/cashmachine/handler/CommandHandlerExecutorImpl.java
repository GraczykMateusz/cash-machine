package dev.graczykmateusz.cashmachine.handler;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;
import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandlerExecutor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

@Slf4j
@SuppressWarnings({"rawtypes", "unchecked"})
class CommandHandlerExecutorImpl implements CommandHandlerExecutor {

  private final Map<Class<? extends Command>, CommandHandler> handlerMap;

  CommandHandlerExecutorImpl(List<CommandHandler> commandHandlers) {
    if (commandHandlers == null) {
      log.warn("There are no command handlers in application context");
      this.handlerMap = new HashMap<>();
      return;
    }

    commandHandlers.forEach(
        commandHandler ->
            log.info(
                "Adding support for command with class: {}",
                commandHandler.handlingCommandClass().getSimpleName()));

    this.handlerMap =
        commandHandlers.stream()
            .collect(Collectors.toMap(CommandHandler::handlingCommandClass, Function.identity()));
  }

  @Override
  public void execute(Command command) {
    CommandHandler handler = handlerMap.get(command.getClass());
    String commandClass = command.getClass().getSimpleName();

    log.info("Executing command with class: {}", commandClass);
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    HandlingStatus handlingStatus = null;
    try {
      handler.handle(command);
      handlingStatus = HandlingStatus.SUCCESS;
    } catch (RuntimeException e) {
      handlingStatus = HandlingStatus.FAIL;
      throw e;
    } finally {
      stopWatch.stop();
      log.info(
          "Command with class: {} executed in {}ms with result {}",
          commandClass,
          stopWatch.getTotalTimeMillis(),
          handlingStatus);
    }
  }
}
