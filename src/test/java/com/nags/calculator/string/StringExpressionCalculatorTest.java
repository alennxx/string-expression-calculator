package com.nags.calculator.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringExpressionCalculatorTest {

    private static final StringExpressionCalculator calculator = StringExpressionCalculator.getInstance();

    @ParameterizedTest
    @MethodSource("calculationTestCases")
    void shouldCorrectlyCalculate(String input, Integer expectedResult) {
        assertThat(calculator.calculate(input)).isEqualTo(expectedResult);
    }

    private static Stream<Arguments> calculationTestCases() {
        return Stream.of(
                Arguments.of("2 + 3", 5),
                Arguments.of("2 + -3", -1),
                Arguments.of("6 - 4", 2),
                Arguments.of("6 - -4", 10),
                Arguments.of("-5 * 2", -10),
                Arguments.of("5 * 12", 60),
                Arguments.of("6 / 2", 3),
                Arguments.of("18 / -3", -6),
                Arguments.of("14 / 3", 4),
                Arguments.of("3 * 2 + 1", 7),
                Arguments.of("3 * -2 + 6", 0)
        );
    }

}
