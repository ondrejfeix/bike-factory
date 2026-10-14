package io.github.ondrejfeix.bikefactory.core;

/**
 * An amount of money in whole currency units. Immutable; negative amounts are allowed.
 * Arithmetic throws ArithmeticException on overflow instead of wrapping.
 */
public record Money(long amount) implements Comparable<Money> {
    public static final Money ZERO = new Money(0);

    public Money plus(Money other) {
        return new Money(Math.addExact(amount, other.amount));
    }

    public Money minus(Money other) {
        return new Money(Math.subtractExact(amount, other.amount));
    }

    @Override
    public int compareTo(Money other) {
        return Long.compare(amount, other.amount);
    }
}
