package com.nags.calculator.expression;

public interface Token {
    Integer evaluate();
    String toInfixNotation();
    String toPostfixNotation();
}
