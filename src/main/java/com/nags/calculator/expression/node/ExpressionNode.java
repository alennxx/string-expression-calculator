package com.nags.calculator.expression.node;

public interface ExpressionNode<N extends Number> {
    N evaluate();
    String toInfixNotation();
    String toPostfixNotation();
}
