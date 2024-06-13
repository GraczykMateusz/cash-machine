package dev.graczykmateusz.cashmachine.shared.domain;

import dev.graczykmateusz.cashmachine.shared.domain.exception.IncorrectLoginException;
import dev.graczykmateusz.cashmachine.policy.PasswordPolicy;

import java.util.Arrays;
import java.util.Objects;

public record Password(char[] value) {

  public Password(PasswordPolicy passwordPolicy, char[] value) {
    this(value);
    if (!passwordPolicy.isValid(value)) {
      throw new IncorrectLoginException("Incorrect login!");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Password password = (Password) o;
    return Objects.deepEquals(value, password.value);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(value);
  }

  @Override
  public String toString() {
    return "Password{" + "value=" + "*".repeat(value.length) + '}';
  }
}
