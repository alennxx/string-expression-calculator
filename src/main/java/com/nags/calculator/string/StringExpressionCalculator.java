package com.nags.calculator.string;

import com.nags.calculator.Calculator;

public class StringExpressionCalculator implements Calculator<String> {

    private static final StringExpressionCalculator instance = new StringExpressionCalculator();

    static StringExpressionCalculator getInstance() {
        return instance;
    }

    private StringExpressionCalculator() {}

    @Override
    public Integer calculate(String s) {
        return 0;
    }

}
