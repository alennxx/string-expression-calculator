package com.nags.calculator.expression;

import com.nags.calculator.operation.Operation;

public class Operator implements ExpressionNode {

    private final Operation operation;
    private final ExpressionNode left;
    private final ExpressionNode right;

    public Operator(Operation operation, ExpressionNode left, ExpressionNode right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer evaluate() {
        return operation.apply(left.evaluate(), right.evaluate());
    }

    @Override
    public String toInfixNotation() {
        return left.toInfixNotation() + Separator.SPACE + operation.symbol() + Separator.SPACE + right.toInfixNotation();
    }

    @Override
    public String toPostfixNotation() {
        return left.toPostfixNotation() + Separator.SPACE + right.toPostfixNotation() + Separator.SPACE + operation.symbol();
    }

}
