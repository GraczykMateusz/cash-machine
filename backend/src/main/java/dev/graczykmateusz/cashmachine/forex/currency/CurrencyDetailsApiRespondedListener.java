package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.forex.currency.scheduler.event.CurrencyDetailsForexResponded;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
class CurrencyDetailsApiRespondedListener {
    
    private final CurrencyDetailsRepository currencyDetailsRepository;
    
    @EventListener
    public void listen(CurrencyDetailsForexResponded event) {
        
        currencyDetailsRepository.save();
    }
}
