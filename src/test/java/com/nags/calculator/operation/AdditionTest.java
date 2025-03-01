package com.nags.calculator.operation;

public class AdditionTest extends OperationTest<Addition> {
    @Override
    Addition operation() {
        return new Addition();
    }

    @Override
    String getExpectedSymbol() {
        return "+";
    }

    @Override
    Integer getExpectedResult(Integer a, Integer b) {
        return a + b;
    }
}
