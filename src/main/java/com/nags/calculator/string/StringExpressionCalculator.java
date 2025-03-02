package com.nags.calculator.string;

import com.nags.calculator.Calculator;
import com.nags.calculator.expression.Expression;
import com.nags.calculator.expression.ExpressionParser;

public class StringExpressionCalculator implements Calculator<String,Integer> {

    private final ExpressionParser<String,String,Integer> expressionParser;

    StringExpressionCalculator(ExpressionParser<String,String,Integer> expressionParser) {
        this.expressionParser = expressionParser;
    }

    @Override
    public Integer calculate(String input) {
        Expression<Integer> expression = expressionParser.parseExpression(input);
        return expression.evaluate();
    }

}
