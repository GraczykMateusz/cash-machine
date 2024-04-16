package dev.graczykmateusz.cashmachine.abstraction.event;

public interface DomainEventListener<T extends DomainEvent> {
    
    void listen(T event);
}
