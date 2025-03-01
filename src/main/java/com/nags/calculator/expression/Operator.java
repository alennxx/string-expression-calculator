package com.nags.calculator.expression;

import com.nags.calculator.operation.Operation;

public class Operator implements Token {

    private final Operation operation;
    private final Token left;
    private final Token right;

    public Operator(Operation operation, Token left, Token right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer evaluate() {
        return operation.apply(left.evaluate(), right.evaluate());
    }

}
