package dev.graczykmateusz.cashmachine;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandlerExecutor;
import dev.graczykmateusz.cashmachine.account.contact.command.AddNewUserContact;
import dev.graczykmateusz.cashmachine.account.contact.command.RemoveAllUserContacts;
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

    
    commandHandlerExecutor.execute(new RemoveAllUserContacts("123"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "0123 4567 8901 2345", "Matthew Kowalsky"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "2345 0123 4567 8933", "Joshua Peterson"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "4567 8901 2345 0123", "Andrew Johnson"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "1123 4567 8901 2345", "Matthew1 Kowalsky"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "2345 0123 4567 8901", "Joshua1 Peterson"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "3567 8901 2345 0123", "Andrew1 Johnson"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "2341 0123 4567 8901", "Joshua2 Peterson"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "4561 8901 2345 0123", "Andre2 Johnson"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "1121 4567 8901 2345", "Matthe2 Kowalsky"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "2341 0123 4567 8111", "Joshua2 Peterson"));
    commandHandlerExecutor.execute(new AddNewUserContact("123", "3561 8901 2345 0123", "Andrew2 Johnson"));
  }
}
