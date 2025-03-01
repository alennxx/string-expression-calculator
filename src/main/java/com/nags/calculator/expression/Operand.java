package com.nags.calculator.expression;

public class Operand implements Token {

    private final Integer value;

    public Operand(Integer value) {
        this.value = value;
    }

    @Override
    public Integer evaluate() {
        return value;
    }

}
