package com.nags.calculator.operation;

public class Division implements Operation {

    private static final String DIVISION_SIGN = "/";

    @Override
    public Integer apply(Integer a, Integer b) {
        return a / b; //TODO division by 0
    }

    @Override
    public String symbol() {
        return DIVISION_SIGN;
    }

    @Override
    public int priority() {
        return 2;
    }
}
