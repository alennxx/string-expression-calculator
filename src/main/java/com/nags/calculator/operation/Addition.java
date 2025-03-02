package com.nags.calculator.operation;

public class Addition implements Operation {

    private static final String ADDITION_SIGN = "+";

    @Override
    public Integer apply(Integer a, Integer b) {
        return a + b;
    }

    @Override
    public String symbol() {
        return ADDITION_SIGN;
    }

    @Override
    public int priority() {
        return 1;
    }
}
