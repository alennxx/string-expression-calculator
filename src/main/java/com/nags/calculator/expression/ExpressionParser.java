package com.nags.calculator.expression;

import com.nags.calculator.expression.node.ExpressionNode;
import com.nags.calculator.expression.node.OperandNode;
import com.nags.calculator.expression.node.OperatorNode;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.OperationRegistry;
import com.nags.calculator.operation.representation.RepresentationType;

import java.util.List;
import java.util.Stack;

public class ExpressionParser<I, T, N extends Number> {

    private final InputParser<I, T> inputParser;
    private final OperandParser<T, N> operandParser;
    private final OperationRegistry<T, N> operationRegistry;

    public ExpressionParser(InputParser<I, T> inputParser, OperandParser<T, N> operandParser,
                            OperatorParser<T,?> operatorParser, List<Operation<N>> supportedOperations) {
        this.inputParser = inputParser;
        this.operandParser = operandParser;
        this.operationRegistry = new OperationRegistry<>(operatorParser, supportedOperations);
    }

    public Expression<N> parseExpression(I expression) {
        final T[] tokens = inputParser.parse(expression);
        final Stack<ExpressionNode<N>> result = new Stack<>();
        final Stack<Operation<N>> operations = new Stack<>();
        for (T token : tokens) {
            if (operandParser.isValid(token)) {
                OperandNode<N> operandNode = new OperandNode<>(operandParser.parse(token));
                result.push(operandNode);
            } else if (operationRegistry.isSupportedOperator(token)) {
                Operation<N> operation = operationRegistry.getOperation(token);
                while (hasPriorityLessOrEqualToTopOperation(operations, operation)) {
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

    private boolean hasPriorityLessOrEqualToTopOperation(Stack<Operation<N>> operations, Operation<N> operation) {
        return !operations.isEmpty() && operations.peek().getPriority() >= operation.getPriority();
    }

    private void pushOperatorForTopOperation(Stack<ExpressionNode<N>> result, Stack<Operation<N>> operations) {
        OperatorNode<T, N> operatorNode = createOperator(result, operations);
        result.push(operatorNode);
    }

    private OperatorNode<T, N> createOperator(Stack<ExpressionNode<N>> result, Stack<Operation<N>> operations) {
        ExpressionNode<N> right = result.pop();
        ExpressionNode<N> left = result.pop();
        return new OperatorNode<>(operations.pop(), left, right);
    }

}
