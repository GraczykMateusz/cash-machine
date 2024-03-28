package dev.graczykmateusz.cashmachine.abstraction.event.incoming;

public interface DomainIncomingEventListener {

  void listen(DomainIncomingEvent event);
}
