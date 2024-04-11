package dev.graczykmateusz.cashmachine.forex.scheduler.event.outgoing;

import dev.graczykmateusz.cashmachine.abstraction.event.outgoing.DomainOutgoingEvent;
import dev.graczykmateusz.cashmachine.forex.scheduler.dto.ForexApiDataDto;

public record ForexApiResponded(ForexApiDataDto forexApiDataDto) implements DomainOutgoingEvent {}
