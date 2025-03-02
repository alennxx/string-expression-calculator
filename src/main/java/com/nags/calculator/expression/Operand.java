package com.nags.calculator.expression;

public class Operand implements ExpressionNode {

    private final Integer value;

    public Operand(Integer value) {
        this.value = value;
    }

    @Override
    public Integer evaluate() {
        return value;
    }

    @Override
    public String toInfixNotation() {
        return value.toString();
    }

    @Override
    public String toPostfixNotation() {
        return value.toString();
    }

}
