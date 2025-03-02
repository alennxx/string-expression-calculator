package com.nags.calculator.expression;

public interface ExpressionNode {
    Integer evaluate();
    String toInfixNotation();
    String toPostfixNotation();
}
