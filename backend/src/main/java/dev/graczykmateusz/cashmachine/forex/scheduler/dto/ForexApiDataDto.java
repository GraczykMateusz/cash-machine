package dev.graczykmateusz.cashmachine.forex.scheduler.dto;

import java.math.BigDecimal;

public record ForexApiDataDto(
    BigDecimal v,
    BigDecimal vw,
    BigDecimal o,
    BigDecimal c,
    BigDecimal h,
    BigDecimal l,
    BigDecimal t,
    BigDecimal n) {}
