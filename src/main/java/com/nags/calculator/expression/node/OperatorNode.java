package com.nags.calculator.expression.node;

import com.nags.calculator.common.Separator;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.representation.RepresentationType;

public class OperatorNode<T, N extends Number> implements ExpressionNode<N> {

    private final Operation<N> operation;
    private final ExpressionNode<N> left;
    private final ExpressionNode<N> right;

    public OperatorNode(Operation<N> operation, ExpressionNode<N> left, ExpressionNode<N> right) {
        this.operation = operation;
        this.left = left;
        this.right = right;
    }

    @Override
    public N evaluate() {
        return operation.apply(left.evaluate(), right.evaluate());
    }

    @Override
    public String toInfixNotation() {
        return left.toInfixNotation() + Separator.SPACE
                + operation.getRepresentation(RepresentationType.SIGN) + Separator.SPACE + right.toInfixNotation();
    }

    @Override
    public String toPostfixNotation() {
        return left.toPostfixNotation() + Separator.SPACE + right.toPostfixNotation()
                + Separator.SPACE+ operation.getRepresentation(RepresentationType.SIGN);
    }

}
