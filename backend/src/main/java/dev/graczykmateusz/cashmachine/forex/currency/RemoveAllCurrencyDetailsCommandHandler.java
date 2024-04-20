package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.forex.currency.command.RemoveAllCurrencyDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class RemoveAllCurrencyDetailsCommandHandler implements CommandHandler<RemoveAllCurrencyDetails> {

  private final CurrencyDetailsRepository repository;

  @Override
  public void handle(RemoveAllCurrencyDetails command) {
    repository.deleteAll();
  }
}
