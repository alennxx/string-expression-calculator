package com.nags.calculator.expression;

public interface OperandParser<T, N extends Number> {
    boolean isValid(T input);
    N parse(T input);
}
