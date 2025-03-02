package com.nags.calculator.operation.impl;

import com.nags.calculator.operation.MathOperation;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.representation.impl.NameRepresentation;
import com.nags.calculator.operation.representation.impl.SignRepresentation;

import java.util.List;

public class Addition<N extends Number> extends Operation<N> {

    public Addition(MathOperation<N> mathOperation) {
        super(mathOperation, List.of(
                new SignRepresentation('+'),
                new NameRepresentation("addition")
        ), 1);
    }

}
