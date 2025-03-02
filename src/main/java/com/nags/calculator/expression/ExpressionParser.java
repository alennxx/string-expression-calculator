package com.nags.calculator.expression;

import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.OperationRegistry;

import java.util.Stack;

public class ExpressionParser<N extends Number> {

    private final OperandParser<N> operandParser;
    private final OperationRegistry<N> operationRegistry;

    public ExpressionParser(OperandParser<N> operandParser, OperationRegistry<N> operationRegistry) {
        this.operandParser = operandParser;
        this.operationRegistry = operationRegistry;
    }

    public Expression<N> parseExpression(String stringExpression) {
        final String[] tokens = stringExpression.split(Separator.SPACE);
        final Stack<ExpressionNode<N>> result = new Stack<>();
        final Stack<Operation<N>> operations = new Stack<>();
        for (String token : tokens) {
            if (operandParser.isValid(token)) {
                Operand<N> operand = new Operand<>(operandParser.parse(token));
                result.push(operand);
            } else if (operationRegistry.isSupportedOperator(token)) {
                Operation<N> operation = operationRegistry.getOperation(token);
                while (!operations.isEmpty() && operations.peek().priority() >= operation.priority()) {
                    pushOperatorForTopOperation(result, operations);
                }
                operations.push(operation);
            } else {
                throw new IllegalArgumentException("Invalid token: " + token);
            }
        }
        while (!operations.isEmpty()) {
            pushOperatorForTopOperation(result, operations);
        }
        return new Expression<>(result.pop());
    }

    private void pushOperatorForTopOperation(Stack<ExpressionNode<N>> result, Stack<Operation<N>> operations) {
        Operator<N> operator = createOperator(result, operations);
        result.push(operator);
    }

    private Operator<N> createOperator(Stack<ExpressionNode<N>> result, Stack<Operation<N>> operations) {
        ExpressionNode<N> right = result.pop();
        ExpressionNode<N> left = result.pop();
        return new Operator<>(operations.pop(), left, right);
    }

}
