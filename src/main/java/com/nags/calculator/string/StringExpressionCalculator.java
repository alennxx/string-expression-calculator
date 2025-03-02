package com.nags.calculator.string;

import com.nags.calculator.Calculator;
import com.nags.calculator.expression.Expression;
import com.nags.calculator.expression.ExpressionParser;

public class StringExpressionCalculator implements Calculator<String> {

    private final ExpressionParser expressionParser;

    StringExpressionCalculator(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    @Override
    public Integer calculate(String input) {
        Expression expression = expressionParser.parseExpression(input);
        return expression.evaluate();
    }

}
