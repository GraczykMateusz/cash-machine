package dev.graczykmateusz.cashmachine.forex.currency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
class CurrencyDetailsConfiguration {
  
  @Bean
  @Primary
  CurrencyDetailsRepository forexDataRepoMongo() {
    return null; // todo
  }
  
  @Bean
  @Profile("dev")
  CurrencyDetailsRepository forexDataRepoInMemory() {
    return new CurrencyDetailsRepositoryInMemory();
  }

  @Bean
  CurrencyDetailsApiRespondedListener currencyDetailsApiRespondedListener(CurrencyDetailsRepository repo) {
    return new CurrencyDetailsApiRespondedListener(repo);
  }
  
  @Bean
  CurrencyDetailsQueryHandler forexQueryHandler(CurrencyDetailsRepository repo) {
    return new CurrencyDetailsQueryHandler(repo);
  }
}
