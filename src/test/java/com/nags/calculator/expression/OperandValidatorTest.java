package com.nags.calculator.expression;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "-1", "0", "345", "-34"})
    void shouldReturnTrueForValidOperand(String token) {
        OperandValidator operandValidator = new OperandValidator();

        assertThat(operandValidator.isValidOperand(token)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "4.5", "3,2", ".9", "-2.3", "+2", "%", "+", "-", " "})
    void shouldReturnFalseForInvalidOperand(String token) {
        OperandValidator operandValidator = new OperandValidator();

        assertThat(operandValidator.isValidOperand(token)).isFalse();
    }

}
