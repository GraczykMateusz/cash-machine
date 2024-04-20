package dev.graczykmateusz.cashmachine;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandlerExecutor;
import dev.graczykmateusz.cashmachine.forex.constants.ExchangeSymbol;
import dev.graczykmateusz.cashmachine.forex.currency.command.RemoveAllCurrencyDetails;
import dev.graczykmateusz.cashmachine.forex.currency.command.UpdateDailyCurrencyDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class CashMachineApplication implements CommandLineRunner {

  private final CommandHandlerExecutor commandHandlerExecutor;

  public static void main(String[] args) {
    SpringApplication.run(CashMachineApplication.class);
  }

  @Override
  public void run(String... args) {
    commandHandlerExecutor.execute(new RemoveAllCurrencyDetails());
    commandHandlerExecutor.execute(new UpdateDailyCurrencyDetails(ExchangeSymbol.EURPLN));
    commandHandlerExecutor.execute(new UpdateDailyCurrencyDetails(ExchangeSymbol.USDPLN));
  }
}
