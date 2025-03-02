package com.nags.calculator.impl;

import com.nags.calculator.operation.MathOperation;

public class IntegerOperations {

    public static class IntegerAddition implements MathOperation<Integer> {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a + b;
        }
    }

    public static class IntegerSubtraction implements MathOperation<Integer> {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a - b;
        }
    }

    public static class IntegerMultiplication implements MathOperation<Integer> {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a * b;
        }
    }

    public static class IntegerDivision implements MathOperation<Integer> {
        @Override
        public Integer apply(Integer a, Integer b) {
            return a / b;
        }
    }

}
