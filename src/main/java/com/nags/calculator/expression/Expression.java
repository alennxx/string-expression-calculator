package com.nags.calculator.expression;

import com.nags.calculator.expression.node.ExpressionNode;

public class Expression<N extends Number> implements ExpressionNode<N> {

    private final ExpressionNode<N> rootExpressionNode;

    Expression(ExpressionNode<N> rootExpressionNode) {
        this.rootExpressionNode = rootExpressionNode;
    }

    @Override
    public N evaluate() {
        return rootExpressionNode.evaluate();
    }

    @Override
    public String toInfixNotation() {
        return rootExpressionNode.toInfixNotation();
    }

    @Override
    public String toPostfixNotation() {
        return rootExpressionNode.toPostfixNotation();
    }

}
