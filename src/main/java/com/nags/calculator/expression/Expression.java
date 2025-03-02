package com.nags.calculator.expression;

public class Expression implements Token {

    private final Token rootToken;

    Expression(Token rootToken) {
        this.rootToken = rootToken;
    }

    @Override
    public Integer evaluate() {
        return rootToken.evaluate();
    }

    @Override
    public String toInfixNotation() {
        return rootToken.toInfixNotation();
    }

    @Override
    public String toPostfixNotation() {
        return rootToken.toPostfixNotation();
    }

}
