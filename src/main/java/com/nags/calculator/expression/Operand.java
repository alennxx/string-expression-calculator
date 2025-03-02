package com.nags.calculator.expression;

public class Operand<N extends Number> implements ExpressionNode<N> {

    private final N value;

    public Operand(N value) {
        this.value = value;
    }

    @Override
    public N evaluate() {
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
