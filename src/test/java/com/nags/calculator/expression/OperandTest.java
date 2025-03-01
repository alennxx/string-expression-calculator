package com.nags.calculator.expression;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandTest {

    private static final Integer OPERAND_POSITIVE_VALUE = 4;
    private static final Integer OPERAND_NEGATIVE_VALUE = -6;

    @Test
    void shouldEvaluate() {
        Operand operand = new Operand(OPERAND_POSITIVE_VALUE);

        Integer evaluationResult = operand.evaluate();

        assertThat(evaluationResult).isEqualTo(OPERAND_POSITIVE_VALUE);
    }

    @ParameterizedTest
    @MethodSource("operandValues")
    void shouldGetValueStringAsInfixNotation(Integer value) {
        shouldGetValueStringAsNotation(value, Operand::toInfixNotation);
    }

    @ParameterizedTest
    @MethodSource("operandValues")
    void shouldGetValueStringAsPrefixNotation(Integer value) {
        shouldGetValueStringAsNotation(value, Operand::toPostfixNotation);
    }

    void shouldGetValueStringAsNotation(Integer value, Function<Operand, String> notationGetter) {
        Operand operand = new Operand(value);

        String infixNotation  = notationGetter.apply(operand);

        assertThat(infixNotation).isEqualTo(value.toString());
    }

    private static Stream<Integer> operandValues() {
        return Stream.of(OPERAND_POSITIVE_VALUE, OPERAND_NEGATIVE_VALUE);
    }

}
