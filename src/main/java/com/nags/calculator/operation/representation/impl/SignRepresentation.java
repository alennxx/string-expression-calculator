package com.nags.calculator.operation.representation.impl;

import com.nags.calculator.operation.representation.BaseRepresentation;
import com.nags.calculator.operation.representation.RepresentationType;

public class SignRepresentation extends BaseRepresentation<Character> {

    public SignRepresentation(Character representation) {
        super(representation, RepresentationType.SIGN);
    }

}
