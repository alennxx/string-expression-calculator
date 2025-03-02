package com.nags.calculator.impl;

import com.nags.calculator.Calculator;
import com.nags.calculator.expression.Expression;
import com.nags.calculator.expression.ExpressionParser;
import com.nags.calculator.expression.InputParser;
import com.nags.calculator.expression.OperandParser;
import com.nags.calculator.operation.OperationRegistry;

public abstract class BaseCalculator<Input,Token,Output extends Number> implements Calculator<Input,Output> {
    private final ExpressionParser<Input,Token,Output> expressionParser;

    protected BaseCalculator(InputParser<Input, Token> inputParser, OperandParser<Token,Output> operandParser,
                             OperationRegistry<Token,Output> operationRegistry) {
        this.expressionParser = new ExpressionParser<>(inputParser, operandParser, operationRegistry);
    }

    @Override
    public final Output calculate(Input input) {
        Expression<Output> expression = expressionParser.parseExpression(input);
        return expression.evaluate();
    }
}
