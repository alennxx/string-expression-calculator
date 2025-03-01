package com.nags.calculator.operation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class OperationTest<O extends Operation> {

    abstract O operation();
    abstract String getExpectedSymbol();
    abstract Integer getExpectedResult(Integer a, Integer b);

    @Test
    void shouldReturnSymbol() {
        assertEquals(getExpectedSymbol(), operation().symbol());
    }

    @ParameterizedTest
    @MethodSource("operationApplicationCases")
    void shouldApply(Integer a, Integer b) {
        assertEquals(getExpectedResult(a, b), operation().apply(a, b));
    }

    private static Stream<Arguments> operationApplicationCases() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(-1, 1),
                Arguments.of(4, 2),
                Arguments.of(6, -3),
                Arguments.of(0, 3)
        );
    }

}
