package dev.graczykmateusz.cashmachine.forex.scheduler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ForexApiResult {
    BigDecimal v;
    BigDecimal vw;
    BigDecimal o;
    BigDecimal c;
    BigDecimal h;
    BigDecimal l;
    BigDecimal t;
    BigDecimal n;
}