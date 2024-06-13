package dev.graczykmateusz.cashmachine.account.command;

import dev.graczykmateusz.cashmachine.abstraction.command.Command;
import java.util.Arrays;
import java.util.Objects;

public record ChangePassword(String accountId, char[] oldPassword, char[] newPassword)
    implements Command {

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ChangePassword that = (ChangePassword) o;
    return Objects.equals(accountId, that.accountId)
        && Objects.deepEquals(oldPassword, that.oldPassword)
        && Objects.deepEquals(newPassword, that.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountId, Arrays.hashCode(oldPassword), Arrays.hashCode(newPassword));
  }

  @Override
  public String toString() {
    return "ChangePassword{"
        + "accountId='"
        + accountId
        + '\''
        + ", oldPassword="
        + Arrays.toString(oldPassword)
        + ", newPassword="
        + Arrays.toString(newPassword)
        + '}';
  }
}
