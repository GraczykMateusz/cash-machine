package dev.graczykmateusz.cashmachine.account.number;

import dev.graczykmateusz.cashmachine.account.number.dto.AccountNumberDto;
import java.util.random.RandomGenerator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class AccountNumberGeneratorImpl implements AccountNumberGenerator {

  private static final long MIN = 0L;
  private static final long MAX = 9999_9999_9999_9999L;

  private static final String EACH_FOUR_NUMBERS_REGEX = "(\\d{4})(?=\\d)";
  private static final Pattern EACH_FOUR_NUMBERS_PATTERN = Pattern.compile(EACH_FOUR_NUMBERS_REGEX);

  private final RandomGenerator randomGenerator;

  @Override
  public AccountNumberDto generate() {
    String number = String.valueOf(randomGenerator.nextLong(MIN, MAX));
    Matcher eachFourNumbersMatcher = EACH_FOUR_NUMBERS_PATTERN.matcher(number);
    String accountNumber = eachFourNumbersMatcher.replaceAll("$1 ").strip();
    return new AccountNumberDto(accountNumber);
  }
}
