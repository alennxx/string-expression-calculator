package com.nags.calculator.operation;

public class DivisionTest extends OperationTest<Division> {
    @Override
    Division operation() {
        return new Division();
    }

    @Override
    String getExpectedSymbol() {
        return "/";
    }

    @Override
    Integer getExpectedResult(Integer a, Integer b) {
        return a / b;
    }
}
