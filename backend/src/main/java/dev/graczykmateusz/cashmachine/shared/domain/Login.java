package dev.graczykmateusz.cashmachine.shared.domain;

import dev.graczykmateusz.cashmachine.shared.domain.exception.IncorrectLoginException;
import dev.graczykmateusz.cashmachine.policy.LoginPolicy;

import java.util.Arrays;
import java.util.Objects;

public record Login(char[] value) {

  public Login(LoginPolicy loginPolicy, char[] value) {
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
    return "Login{" + "value=" + "*".repeat(value.length) + '}';
  }
}
