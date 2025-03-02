package com.nags.calculator.expression;

import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.OperationRegistry;

import java.util.Stack;

public class ExpressionParser {

    private final OperandValidator operandValidator;
    private final OperationRegistry operationRegistry;

    public ExpressionParser(OperandValidator operandValidator, OperationRegistry operationRegistry) {
        this.operandValidator = operandValidator;
        this.operationRegistry = operationRegistry;
    }

    Expression parseExpression(String stringExpression) {
        final String[] tokens = stringExpression.split(Separator.SPACE);
        final Stack<Token> result = new Stack<>();
        final Stack<Operation> operations = new Stack<>();
        for (String token : tokens) {
            if (operandValidator.isValidOperand(token)) {
                Operand operand = new Operand(Integer.parseInt(token));
                result.push(operand);
            } else if (operationRegistry.isSupportedOperator(token)) {
                Operation operation = operationRegistry.getOperation(token);
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
        return new Expression(result.pop());
    }

    private void pushOperatorForTopOperation(Stack<Token> result, Stack<Operation> operations) {
        Operator operator = createOperator(result, operations);
        result.push(operator);
    }

    private Operator createOperator(Stack<Token> result, Stack<Operation> operations) {
        Token right = result.pop();
        Token left = result.pop();
        return new Operator(operations.pop(), left, right);
    }

}
