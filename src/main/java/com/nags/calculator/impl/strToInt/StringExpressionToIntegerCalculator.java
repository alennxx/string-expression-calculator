package com.nags.calculator.impl.strToInt;

import com.nags.calculator.common.Separator;
import com.nags.calculator.impl.BaseCalculator;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.OperationRegistry;

import java.util.List;

public class StringExpressionToIntegerCalculator extends BaseCalculator<String,String,Integer> {

    StringExpressionToIntegerCalculator() {
        super(new StringInputParser(Separator.SPACE), new IntegerParser(), operationRegistry());
    }

    private static OperationRegistry<String,Integer> operationRegistry() {
        List<Operation<String,Integer>> supportedOperations = List.of(
            new Operation<>(new IntegerOperations.IntegerAddition(), "+", 1),
            new Operation<>(new IntegerOperations.IntegerSubtraction(), "-", 1),
            new Operation<>(new IntegerOperations.IntegerMultiplication(), "*", 2),
            new Operation<>(new IntegerOperations.IntegerDivision(), "/", 2));
        return new OperationRegistry<>(supportedOperations);
    }

}
