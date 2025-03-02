package com.nags.calculator.strToInt;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerParserTest {

    @ParameterizedTest
    @MethodSource("validIntegerStrings")
    void shouldReturnTrueForValidOperand(String token) {
        IntegerParser integerParser = new IntegerParser();

        assertThat(integerParser.isValid(token)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "4.5", "3,2", ".9", "-2.3", "+2", "%", "+", "-", " "})
    void shouldReturnFalseForInvalidOperand(String token) {
        IntegerParser integerParser = new IntegerParser();

        assertThat(integerParser.isValid(token)).isFalse();
    }

    @ParameterizedTest
    @MethodSource("validIntegerStrings")
    void shouldParse(String input) {
        IntegerParser integerParser = new IntegerParser();

        assertThat(integerParser.parse(input)).isNotNull()
                .extracting(Object::toString).isEqualTo(input);
    }

    private static Stream<String> validIntegerStrings() {
        return Stream.of("1", "-1", "0", "345", "-34");
    }

}
