package dev.graczykmateusz.cashmachine.forex.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;

@RequiredArgsConstructor
class ForexScheduler {

  private final ForexClient client;
  private final ForexApiRespondedPublisher publisher;
  
  @Scheduled(fixedDelay = 13000)
  void getInfo() {
    ForexApiResponse forexApiResponse = client.getForexData();
//    publisher.publish(); todo
  }
}
