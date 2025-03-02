package com.nags.calculator.expression.node;

public class OperandNode<N extends Number> implements ExpressionNode<N> {

    private final N value;

    public OperandNode(N value) {
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
