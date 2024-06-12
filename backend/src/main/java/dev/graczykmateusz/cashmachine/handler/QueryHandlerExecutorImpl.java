package dev.graczykmateusz.cashmachine.handler;

import dev.graczykmateusz.cashmachine.abstraction.exception.CashMachineException;
import dev.graczykmateusz.cashmachine.abstraction.query.Query;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandlerExecutor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import dev.graczykmateusz.cashmachine.abstraction.query.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

@Slf4j
@SuppressWarnings({"rawtypes", "unchecked"})
class QueryHandlerExecutorImpl implements QueryHandlerExecutor {

  private final Map<Class<? extends Query>, QueryHandler> handlerMap;

  QueryHandlerExecutorImpl(List<QueryHandler> commandHandlers) {
    if (commandHandlers == null) {
      log.warn("There are no query handlers in application context");
      this.handlerMap = new HashMap<>();
      return;
    }

    commandHandlers.forEach(
        commandHandler ->
            log.info(
                "Adding support for query with class: {}",
                commandHandler.handlingCommandClass().getSimpleName()));

    this.handlerMap =
        commandHandlers.stream()
            .collect(Collectors.toMap(QueryHandler::handlingCommandClass, Function.identity()));
  }

  @Override
  public Result execute(Query query) {
    QueryHandler handler = handlerMap.get(query.getClass());
    String queryClass = query.getClass().getSimpleName();

    log.info("Executing query with class: {}", queryClass);
    StopWatch stopWatch = new StopWatch();
    stopWatch.start();
    HandlingStatus handlingStatus = null;
    try {
      Result result = handler.handle(query);
      handlingStatus = HandlingStatus.SUCCESS;
      return result;
    } catch (CashMachineException e) {
      handlingStatus = HandlingStatus.FAIL;
      throw e;
    } finally {
      stopWatch.stop();
      log.info(
          "Query with class: {} executed in {}ms with result {}",
          queryClass,
          stopWatch.getTotalTimeMillis(),
          handlingStatus);
    }
  }
}
