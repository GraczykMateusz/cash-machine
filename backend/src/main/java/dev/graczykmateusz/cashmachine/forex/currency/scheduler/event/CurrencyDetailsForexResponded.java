package dev.graczykmateusz.cashmachine.forex.currency.scheduler.event;

import dev.graczykmateusz.cashmachine.abstraction.event.DomainEvent;
import dev.graczykmateusz.cashmachine.forex.client.dto.CurrencyDetailsForexResponseDto;

public record CurrencyDetailsForexResponded(
    CurrencyDetailsForexResponseDto currencyDetailsForexResponseDto) implements DomainEvent {}
