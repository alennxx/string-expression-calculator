package com.nags.calculator.operation;

public interface Operation {
    Integer apply(Integer a, Integer b);
    String symbol();
    int priority();
}
