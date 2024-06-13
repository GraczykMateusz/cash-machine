package dev.graczykmateusz.cashmachine.account.number;

import java.util.SplittableRandom;
import java.util.random.RandomGenerator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class AccountNumberGeneratorConfiguration {

  @Bean("accountNumberGenerator")
  AccountNumberGenerator accountNumberGenerator() {
    RandomGenerator splittableRandom = new SplittableRandom();
    return new AccountNumberGeneratorImpl(splittableRandom);
  }
}
