package com.nags.calculator;

public interface Calculator<Input,Output extends Number> {
    Output calculate(Input input);
}
