package com.nags.calculator.impl.strToInt;

import com.nags.calculator.operation.MathOperation;

import java.util.function.Predicate;

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

    public static class IsIntegerZero implements Predicate<Integer> {

        @Override
        public boolean test(Integer integer) {
            return integer == 0;
        }
    }

}
