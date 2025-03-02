package com.nags.calculator.expression;

public interface ExpressionNode<N extends Number> {
    N evaluate();
    String toInfixNotation();
    String toPostfixNotation();
}
