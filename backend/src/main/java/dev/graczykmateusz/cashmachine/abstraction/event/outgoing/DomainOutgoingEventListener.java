package dev.graczykmateusz.cashmachine.abstraction.event.outgoing;

public interface DomainOutgoingEventListener {
    
    void listen(DomainOutgoingEvent event);
}
