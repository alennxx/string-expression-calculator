package com.nags.calculator.string;

import com.nags.calculator.Calculator;
import com.nags.calculator.expression.Expression;
import com.nags.calculator.expression.ExpressionParser;

public class StringExpressionCalculator implements Calculator<String> {

    private final ExpressionParser<Integer> expressionParser;

    StringExpressionCalculator(ExpressionParser<Integer> expressionParser) {
        this.expressionParser = expressionParser;
    }

    @Override
    public Integer calculate(String input) {
        Expression<Integer> expression = expressionParser.parseExpression(input);
        return expression.evaluate();
    }

}
