package com.nags;

import com.nags.calculator.impl.strToInt.StringExpressionToIntegerCalculator;

public class Main {
    public static void main(String[] args) {
        StringExpressionToIntegerCalculator calculator = new StringExpressionToIntegerCalculator();
        Integer output = calculator.calculate("5 / 1 + 2");
        //Integer output = calculator.calculate("5 / 0");
        System.out.println(output);
    }
}