package dev.graczykmateusz.cashmachine.handler;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandlerExecutor;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandlerExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration(proxyBeanMethods = false)
class HandlersConfiguration {
    
    @Bean
    @SuppressWarnings({"rawtypes"})
    public CommandHandlerExecutor commandHandlerExecutor(
            @Autowired(required = false) List<CommandHandler> commandHandlers) {
        return new CommandHandlerExecutorImpl(commandHandlers);
    }
    
    @Bean
    @SuppressWarnings({"rawtypes"})
    public QueryHandlerExecutor queryHandlerExecutor(
            @Autowired(required = false) List<QueryHandler> queryHandlers) {
        return new QueryHandlerExecutorImpl(queryHandlers);
    }
}
