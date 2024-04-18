package dev.graczykmateusz.cashmachine.forex.client;

import java.time.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ForexClock {

  private final Clock clock;

  long getFrom() {
    long epochMilli = getOneYearBeforeCurrentDateInstant().minusSeconds(1).toEpochMilli();
    System.out.println(epochMilli);
    return epochMilli;
  }

  long getTo() {
    return getOneYearBeforeCurrentDateInstant().toEpochMilli();
  }

  private Instant getOneYearBeforeCurrentDateInstant() {
    LocalDateTime currentDateTime = LocalDateTime.now(clock);
    LocalDateTime oneYearBefore = currentDateTime.minusYears(1);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(oneYearBefore, ZoneId.systemDefault());
    return zonedDateTime.toInstant();
  }
}
