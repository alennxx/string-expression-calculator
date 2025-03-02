package com.nags.calculator.expression;

import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.OperationRegistry;

import java.util.Stack;

public class ExpressionParser<I, T, N extends Number> {

    private final InputParser<I, T> inputParser;
    private final OperandParser<T, N> operandParser;
    private final OperationRegistry<T, N> operationRegistry;

    public ExpressionParser(InputParser<I, T> inputParser, OperandParser<T, N> operandParser,
                            OperationRegistry<T, N> operationRegistry) {
        this.inputParser = inputParser;
        this.operandParser = operandParser;
        this.operationRegistry = operationRegistry;
    }

    public Expression<N> parseExpression(I expression) {
        final T[] tokens = inputParser.parse(expression);
        final Stack<ExpressionNode<N>> result = new Stack<>();
        final Stack<Operation<T, N>> operations = new Stack<>();
        for (T token : tokens) {
            if (operandParser.isValid(token)) {
                Operand<N> operand = new Operand<>(operandParser.parse(token));
                result.push(operand);
            } else if (operationRegistry.isSupportedOperator(token)) {
                Operation<T, N> operation = operationRegistry.getOperation(token);
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

    private void pushOperatorForTopOperation(Stack<ExpressionNode<N>> result, Stack<Operation<T, N>> operations) {
        Operator<T, N> operator = createOperator(result, operations);
        result.push(operator);
    }

    private Operator<T, N> createOperator(Stack<ExpressionNode<N>> result, Stack<Operation<T, N>> operations) {
        ExpressionNode<N> right = result.pop();
        ExpressionNode<N> left = result.pop();
        return new Operator<>(operations.pop(), left, right);
    }

}
