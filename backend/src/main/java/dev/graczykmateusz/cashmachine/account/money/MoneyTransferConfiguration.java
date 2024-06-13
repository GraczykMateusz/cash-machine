package dev.graczykmateusz.cashmachine.account.money;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.account.money.dto.MoneyBalanceDto;
import dev.graczykmateusz.cashmachine.account.money.query.GetMoneyBalance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
class MoneyTransferConfiguration {

  @Bean
  QueryHandler<MoneyBalanceDto, GetMoneyBalance> getMoneyBalanceQueryHandler(
      MoneyTransferRepository repository) {
    var moneyTransferQueryRepository = new MoneyTransferQueryRepositoryImpl(repository);
    return new GetMoneyBalanceQueryHandler(moneyTransferQueryRepository);
  }
}
