package dev.graczykmateusz.cashmachine.abstraction.event;

public interface DomainEventPublisher<T extends DomainEvent> {

  void publish(T event);
}
