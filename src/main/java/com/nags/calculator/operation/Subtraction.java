package com.nags.calculator.operation;

public class Subtraction implements Operation {

    private static final String SUBTRACTION_SIGN = "-";

    @Override
    public Integer apply(Integer a, Integer b) {
        return a - b;
    }

    @Override
    public String symbol() {
        return SUBTRACTION_SIGN;
    }

    @Override
    public int priority() {
        return 1;
    }
}
