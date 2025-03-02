package com.nags.calculator.operation.representation.impl;

import com.nags.calculator.operation.representation.BaseRepresentation;
import com.nags.calculator.operation.representation.RepresentationType;

public class NameRepresentation extends BaseRepresentation<String> {
    public NameRepresentation(String representation) {
        super(representation, RepresentationType.NAME);
    }
}
