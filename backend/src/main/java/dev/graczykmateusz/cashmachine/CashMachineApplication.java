package dev.graczykmateusz.cashmachine;

import dev.graczykmateusz.cashmachine.abstraction.command.CommandHandlerExecutor;
import dev.graczykmateusz.cashmachine.account.command.CreateAccount;
import dev.graczykmateusz.cashmachine.account.command.RemoveAllAccounts;
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
    // clean up
    commandHandlerExecutor.execute(new RemoveAllAccounts());
    commandHandlerExecutor.execute(new RemoveAllCurrencyDetails());

    // currency details
    commandHandlerExecutor.execute(new UpdateDailyCurrencyDetails(ExchangeSymbol.EURPLN));
    commandHandlerExecutor.execute(new UpdateDailyCurrencyDetails(ExchangeSymbol.USDPLN));

    // accounts
    commandHandlerExecutor.execute(
        new CreateAccount(
            "Mateusz", "Graczyk", "123456789", "ADMIN123".toCharArray(), "ADMIN123".toCharArray()));
    commandHandlerExecutor.execute(
        new CreateAccount(
            "Joshua", "Evans", "987654321", "LOGIN123".toCharArray(), "PASSWORD123".toCharArray()));
    commandHandlerExecutor.execute(
        new CreateAccount(
            "Ava", "Smith", "010203040", "LOGIN321".toCharArray(), "PASSWORD3212".toCharArray()));

    // user contacts
    commandHandlerExecutor.execute(
        new AddNewUserContact("123", "0123 4567 8901 2345", "Matthew Kowalsky"));
    commandHandlerExecutor.execute(
        new AddNewUserContact("123", "2345 0123 4567 8933", "Joshua Peterson"));
    commandHandlerExecutor.execute(
        new AddNewUserContact("123", "4567 8901 2345 0123", "Andrew Johnson"));
    commandHandlerExecutor.execute(
        new AddNewUserContact("123", "1123 4567 8901 2345", "Matthew1 Kowalsky"));
  }
}
