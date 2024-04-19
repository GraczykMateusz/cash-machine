package dev.graczykmateusz.cashmachine.forex.client;

import java.time.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ForexClock {

  private final Clock clock;

  long getFrom() {
    return getOneYearBeforeCurrentDateInstant().minusSeconds(1).toEpochMilli();
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
