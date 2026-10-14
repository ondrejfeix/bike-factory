package io.github.ondrejfeix.bikefactory.core;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Money")
class MoneyTest {

    @Test
    @DisplayName("adds two amounts together")
    void addsCorrectly() {
        Money value1 = new Money(1);
        Money value2 = new Money(2);

        assertThat(value1.plus(value2)).isEqualTo(new Money(3));
    }

    @Test
    @DisplayName("throws on overflow instead of wrapping to a negative amount")
    void throwsOnOverflowInsteadOfWrapping() {
        Money max = new Money(Long.MAX_VALUE);

        assertThatThrownBy(() -> max.plus(new Money(1)))
                .isInstanceOf(ArithmeticException.class);
    }
}