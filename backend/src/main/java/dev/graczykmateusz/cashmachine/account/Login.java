package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.account.exception.IncorrectLoginException;
import java.util.Arrays;
import java.util.Objects;

record Login(char[] value) {

  Login(LoginPolicy loginPolicy, char[] value) {
    this(value);
    if (!loginPolicy.isValid(value)) {
      throw new IncorrectLoginException("Incorrect login!");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Login login = (Login) o;
    return Objects.deepEquals(value, login.value);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(value);
  }

  @Override
  public String toString() {
    return "Login{" + "value=" + Arrays.toString(value) + '}';
  }
}
