package com.nags.calculator.strToInt;

import com.nags.calculator.common.Separator;
import com.nags.calculator.impl.BaseCalculator;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.OperationRegistry;

public class StringExpressionToIntegerCalculator extends BaseCalculator<String,String,Integer> {

    StringExpressionToIntegerCalculator() {
        super(new StringInputParser(Separator.SPACE), new IntegerParser(), operationRegistry());
    }

    static OperationRegistry<String,Integer> operationRegistry() {
        OperationRegistry<String,Integer> registry = new OperationRegistry<>();
        registry.register(new Operation<>(new IntegerOperations.IntegerAddition(), "+", 1));
        registry.register(new Operation<>(new IntegerOperations.IntegerSubtraction(), "-", 1));
        registry.register(new Operation<>(new IntegerOperations.IntegerMultiplication(), "*", 2));
        registry.register(new Operation<>(new IntegerOperations.IntegerDivision(), "/", 2));
        return registry;
    }

}
