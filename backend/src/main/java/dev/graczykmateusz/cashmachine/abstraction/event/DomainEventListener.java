package dev.graczykmateusz.cashmachine.abstraction.event;

public interface DomainEventListener {
    
    void listen(DomainEvent event);
}
