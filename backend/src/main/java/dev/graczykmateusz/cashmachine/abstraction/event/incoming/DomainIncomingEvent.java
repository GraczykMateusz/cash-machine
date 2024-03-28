package dev.graczykmateusz.cashmachine.abstraction.event.incoming;

import java.io.Serializable;
import java.time.Instant;

public interface DomainIncomingEvent extends Serializable {
    Instant getWhen();
    Integer getSequenceNumber();
}
