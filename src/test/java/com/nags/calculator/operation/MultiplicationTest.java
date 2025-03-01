package com.nags.calculator.operation;

public class MultiplicationTest extends OperationTest<Multiplication> {
    @Override
    Multiplication operation() {
        return new Multiplication();
    }

    @Override
    String getExpectedSymbol() {
        return "*";
    }

    @Override
    Integer getExpectedResult(Integer a, Integer b) {
        return a * b;
    }
}
