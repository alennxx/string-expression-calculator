package com.nags.calculator.impl.strToInt;

import com.nags.calculator.expression.OperatorParser;
import com.nags.calculator.operation.representation.RepresentationType;

public class StringToSignParser implements OperatorParser<String, Character> {
    @Override
    public Character parse(String s) {
        return s.charAt(0);
    }

    @Override
    public RepresentationType getRepresentationType() {
        return RepresentationType.SIGN;
    }
}
