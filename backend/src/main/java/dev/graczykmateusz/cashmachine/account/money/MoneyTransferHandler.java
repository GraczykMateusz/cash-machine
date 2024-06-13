package dev.graczykmateusz.cashmachine.account.money;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.account.money.command.ExecuteMoneyTransfer;
import dev.graczykmateusz.cashmachine.shared.domain.Money;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class MoneyTransferHandler implements CommandHandler<ExecuteMoneyTransfer> {

  private final MoneyTransferRepository repository;

  @Override
  public void handle(ExecuteMoneyTransfer command) {
    Money money = new Money(command.amount());
    MoneyTransfer moneyTransfer =
        new MoneyTransfer(command.senderAccountId(), command.receiverAccountId(), money);
    repository.save(moneyTransfer);
  }
}
