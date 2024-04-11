package dev.graczykmateusz.cashmachine.forex;

import dev.graczykmateusz.cashmachine.forex.scheduler.event.outgoing.ForexApiResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class ForexApiRespondedListener {
    
    private final ForexRepository forexRepository;
    
    @EventListener
    public void listen(ForexApiResponded forexApiResponded) {
    
    }
}
