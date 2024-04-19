package dev.graczykmateusz.cashmachine.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;

@Slf4j
public class ApplicationEventPublisherInMemory implements ApplicationEventPublisher {

  private final List<Object> events = Collections.synchronizedList(new ArrayList<>());

  @Override
  public void publishEvent(Object event) {
    log.debug("Publishing event {}", event);
    events.add(event);
  }

  public List<Object> getEvents() {
    return Collections.unmodifiableList(events);
  }
}
