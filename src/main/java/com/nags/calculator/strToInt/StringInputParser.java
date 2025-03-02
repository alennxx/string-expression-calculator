package com.nags.calculator.strToInt;

import com.nags.calculator.expression.InputParser;

public class StringInputParser implements InputParser<String,String> {
    private final String separator;

    public StringInputParser(String separator) {
        this.separator = separator;
    }

    @Override
    public String[] parse(String input) {
        return input.split(separator);
    }
}
