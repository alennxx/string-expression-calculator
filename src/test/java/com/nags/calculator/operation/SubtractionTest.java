package com.nags.calculator.operation;

public class SubtractionTest extends OperationTest<Subtraction> {
    @Override
    Subtraction operation() {
        return new Subtraction();
    }

    @Override
    String getExpectedSymbol() {
        return "-";
    }

    @Override
    Integer getExpectedResult(Integer a, Integer b) {
        return a - b;
    }
}
