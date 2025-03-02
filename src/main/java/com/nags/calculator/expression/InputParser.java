package com.nags.calculator.expression;

public interface InputParser<I,T> {
    T[] parse(I input);
}
