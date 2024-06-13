package dev.graczykmateusz.cashmachine.account.money;

import dev.graczykmateusz.cashmachine.abstraction.query.QueryHandler;
import dev.graczykmateusz.cashmachine.account.money.dto.MoneyBalanceDto;
import dev.graczykmateusz.cashmachine.account.money.query.GetMoneyBalance;

import dev.graczykmateusz.cashmachine.shared.domain.Money;
import dev.graczykmateusz.cashmachine.shared.domain.MoneyBalance;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetMoneyBalanceQueryHandler implements QueryHandler<MoneyBalanceDto, GetMoneyBalance> {

  private final MoneyTransferQueryRepository queryRepository;

  @Override
  public MoneyBalanceDto handle(GetMoneyBalance query) {
    MoneyTransfers receivedMoneyTransfers =
        queryRepository.findByReceiverAccountId(query.accountId());
    MoneyTransfers sentMoneyTransfers =
        queryRepository.findBySenderAccountId(query.accountId());
    
    Money income = receivedMoneyTransfers.sum();
    Money outcome = sentMoneyTransfers.sum();
    
    MoneyBalance moneyBalance = new MoneyBalance(income, outcome);
    return MoneyBalanceMapper.toDto(moneyBalance);
  }
}
