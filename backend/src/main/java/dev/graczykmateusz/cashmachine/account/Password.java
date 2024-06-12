package dev.graczykmateusz.cashmachine.account;

import dev.graczykmateusz.cashmachine.account.exception.IncorrectLoginException;

import java.util.Arrays;
import java.util.Objects;

record Password(char[] value) {
  
  Password(PasswordPolicy passwordPolicy, char[] value) {
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
    return "Password{" + "value=" + Arrays.toString(value) + '}';
  }
}
