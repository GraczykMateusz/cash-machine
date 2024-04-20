package dev.graczykmateusz.cashmachine.forex.client;

import java.time.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ForexClock {

  private final Clock clock;

  long getCurrentFrom() {
    return getOneYearBeforeCurrentDateInstant().minusSeconds(1).toEpochMilli();
  }

  long getCurrentTo() {
    return getOneYearBeforeCurrentDateInstant().toEpochMilli();
  }

  long getDailyFrom() {
    return getOneYearAnd24hBeforeCurrentDateInstant().toEpochMilli();
  }

  long getDailyTo() {
    return getOneYearBeforeCurrentDateInstant().toEpochMilli();
  }

  private Instant getOneYearBeforeCurrentDateInstant() {
    LocalDateTime currentDateTime = LocalDateTime.now(clock);
    LocalDateTime oneYearBefore = currentDateTime.minusYears(1);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(oneYearBefore, ZoneId.systemDefault());
    return zonedDateTime.toInstant();
  }

  private Instant getOneYearAnd24hBeforeCurrentDateInstant() {
    LocalDateTime currentDateTime = LocalDateTime.now(clock);
    LocalDateTime oneYearAnd24hBefore = currentDateTime.minusYears(1).minusDays(1);
    ZonedDateTime zonedDateTime = ZonedDateTime.of(oneYearAnd24hBefore, ZoneId.systemDefault());
    return zonedDateTime.toInstant();
  }
}
