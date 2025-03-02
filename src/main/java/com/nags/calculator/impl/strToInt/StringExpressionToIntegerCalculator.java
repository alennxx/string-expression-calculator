package com.nags.calculator.impl.strToInt;

import com.nags.calculator.common.Separator;
import com.nags.calculator.impl.BaseCalculator;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.impl.Addition;
import com.nags.calculator.operation.impl.Division;
import com.nags.calculator.operation.impl.Multiplication;
import com.nags.calculator.operation.impl.Subtraction;

import java.util.List;

public class StringExpressionToIntegerCalculator extends BaseCalculator<String,String,Integer> {

    StringExpressionToIntegerCalculator() {
        super(new StringInputParser(Separator.SPACE), new IntegerParser(), new StringToSignParser(), supportedOperations());
    }

    private static List<Operation<Integer>> supportedOperations() {
        return List.of(
            new Addition<>(new IntegerOperations.IntegerAddition()),
            new Subtraction<>(new IntegerOperations.IntegerSubtraction()),
            new Multiplication<>(new IntegerOperations.IntegerMultiplication()),
            new Division<>(new IntegerOperations.IntegerDivision()));
    }

}
