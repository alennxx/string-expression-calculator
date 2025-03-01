package com.nags.calculator.operation;

public class Multiplication implements Operation {

    private static final String MULTIPLICATION_SIGN = "*";

    @Override
    public Integer apply(Integer a, Integer b) {
        return a * b;
    }

    @Override
    public String symbol() {
        return MULTIPLICATION_SIGN;
    }
}
