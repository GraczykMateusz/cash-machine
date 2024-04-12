package dev.graczykmateusz.cashmachine.abstraction.event;

public interface DomainEventPublisher {

  void publish(DomainEvent event);
}
