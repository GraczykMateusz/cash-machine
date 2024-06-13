package dev.graczykmateusz.cashmachine.shared.domain;

import dev.graczykmateusz.cashmachine.shared.domain.exception.IncorrectMoneyException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public record Money(BigDecimal value) {

  public Money {
    if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IncorrectMoneyException("Money value must be positive!");
    }
  }

  public Money add(Money other) {
    Objects.requireNonNull(other, "Other money must not be null");
    return new Money(this.value.add(other.value));
  }

  public Money subtract(Money other) {
    Objects.requireNonNull(other, "Other money must not be null");
    BigDecimal result = this.value.subtract(other.value);
    if (result.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Resulting money value must be positive!");
    }
    return new Money(result);
  }

  public Money multiply(BigDecimal factor) {
    Objects.requireNonNull(factor, "Factor must not be null");
    if (factor.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Factor must be positive!");
    }
    return new Money(this.value.multiply(factor).setScale(2, RoundingMode.HALF_UP));
  }

  public Money divide(BigDecimal divisor) {
    Objects.requireNonNull(divisor, "Divisor must not be null");
    if (divisor.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("Divisor must be positive!");
    }
    return new Money(this.value.divide(divisor, 2, RoundingMode.HALF_UP));
  }

  public int compareTo(Money other) {
    Objects.requireNonNull(other, "Other money must not be null");
    return this.value.compareTo(other.value);
  }
}
