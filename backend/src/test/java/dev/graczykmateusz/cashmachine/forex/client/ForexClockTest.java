package dev.graczykmateusz.cashmachine.forex.client;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.*;
class ForexClockTest {
    
    @Test
    void getCurrentFrom() {
      }
    
    @Test
    void getCurrentTo() {
      }
    
    @Test
    void getDailyFrom() {
        Clock fixedClock = Clock.fixed(Instant.parse("2024-04-24T19:15:30.00Z"), ZoneId.systemDefault());
        ForexClock forexClock = new ForexClock(fixedClock);
        long dailyFrom = forexClock.getDailyFrom();
        Instant instant = Instant.ofEpochMilli(dailyFrom);
        System.out.println(instant);
    }
    
    @Test
    void getDailyTo() {
      }
}