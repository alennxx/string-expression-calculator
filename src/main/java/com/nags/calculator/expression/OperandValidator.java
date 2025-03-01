package com.nags.calculator.expression;

import org.apache.commons.lang3.math.NumberUtils;

public class OperandValidator {

    private static final String OPERAND_PATTERN = "^-?\\d+$";

    boolean isValidOperand(String token) {
        return NumberUtils.isParsable(token) && token.matches(OPERAND_PATTERN);
    }
}
