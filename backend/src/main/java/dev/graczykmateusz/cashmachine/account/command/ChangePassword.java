package dev.graczykmateusz.cashmachine.account.command;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;

import java.util.Arrays;
import java.util.Objects;

public record ChangePassword(String accountId, char[] password) implements Command {

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChangePassword that = (ChangePassword) o;
    return Objects.deepEquals(password, that.password) && Objects.equals(accountId, that.accountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, Arrays.hashCode(password));
  }

  @Override
  public String toString() {
    return "ChangePassword{"
        + "accountId='"
        + accountId
        + '\''
        + ", password="
        + Arrays.toString(password)
        + '}';
  }
}
