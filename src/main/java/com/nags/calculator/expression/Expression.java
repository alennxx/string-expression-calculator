package com.nags.calculator.expression;

public class Expression implements ExpressionNode {

    private final ExpressionNode rootExpressionNode;

    Expression(ExpressionNode rootExpressionNode) {
        this.rootExpressionNode = rootExpressionNode;
    }

    @Override
    public Integer evaluate() {
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
