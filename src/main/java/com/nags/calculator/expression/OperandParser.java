package com.nags.calculator.expression;

public interface OperandParser<N extends Number> {
    boolean isValid(String input);
    N parse(String input);
}
