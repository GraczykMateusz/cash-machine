package dev.graczykmateusz.cashmachine.account.password.dto;

import java.util.Arrays;
import java.util.Objects;

public record EncodedPassword(char[] value) {

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    EncodedPassword that = (EncodedPassword) o;
    return Objects.deepEquals(value, that.value);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(value);
  }

  @Override
  public String toString() {
    return "EncodedPassword{" + "*".repeat(value.length) + '}';
  }
}
