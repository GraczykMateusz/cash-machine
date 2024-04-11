package dev.graczykmateusz.cashmachine.forex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
class ForexConfiguration {
  
  @Bean
  @Primary
  ForexRepository forexDataRepoMongo() {
    return null; // todo
  }
  
  @Bean
  @Profile("dev")
  ForexRepository forexDataRepoInMemory() {
    return new ForexRepositoryInMemory();
  }

  @Bean
  ForexApiRespondedListener forexFacade(ForexRepository repo) {
    return new ForexApiRespondedListener(repo);
  }
}
