package com.nags.calculator.impl;

import com.nags.calculator.expression.OperandParser;
import org.apache.commons.lang3.math.NumberUtils;

public class IntegerParser implements OperandParser<Integer> {

    private static final String OPERAND_PATTERN = "^-?\\d+$";

    @Override
    public boolean isValid(String input) {
        return NumberUtils.isParsable(input) && input.matches(OPERAND_PATTERN);
    }

    @Override
    public Integer parse(String input) {
        return Integer.parseInt(input);
    }
}
