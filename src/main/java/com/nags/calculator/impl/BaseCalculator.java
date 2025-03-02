package com.nags.calculator.impl;

import com.nags.calculator.Calculator;
import com.nags.calculator.expression.*;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.representation.RepresentationType;

import java.util.List;

public abstract class BaseCalculator<Input,Token,Output extends Number> implements Calculator<Input,Output> {
    private final ExpressionParser<Input,Token,Output> expressionParser;

    protected BaseCalculator(InputParser<Input, Token> inputParser, OperandParser<Token,Output> operandParser,
            OperatorParser<Token,?> operatorParser, List<Operation<Output>> supportedOperations) {
        this.expressionParser = new ExpressionParser<>(inputParser, operandParser, operatorParser, supportedOperations);
    }

    @Override
    public final Output calculate(Input input) {
        Expression<Output> expression = expressionParser.parseExpression(input);
        return expression.evaluate();
    }
}
