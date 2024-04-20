package dev.graczykmateusz.cashmachine.forex.currency;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandler;
import dev.graczykmateusz.cashmachine.forex.client.CurrencyForexClient;
import dev.graczykmateusz.cashmachine.forex.currency.command.UpdateDailyCurrencyDetails;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class UpdateDailyCurrencyDetailsCommandHandler
    implements CommandHandler<UpdateDailyCurrencyDetails> {
  private final CurrencyForexClient client;
  private final CurrencyDetailsRepository repository;

  @Override
  public void handle(UpdateDailyCurrencyDetails command) {
    var currencyDetailsForexResponseMono =
        client.retrieveDailyCurrencyDetails(command.exchangeSymbol());

    currencyDetailsForexResponseMono.subscribe(
        currencyDetailsForexResponse -> {
          CurrencyDetails currencyDetails =
              CurrencyDetailsMapper.fromDto(currencyDetailsForexResponse);
          repository.save(currencyDetails);
        });
  }
}
