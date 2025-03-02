package com.nags.calculator.operation.impl;

import com.nags.calculator.operation.MathOperation;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.representation.NameRepresentation;
import com.nags.calculator.operation.representation.SignRepresentation;

import java.util.List;

public class Subtraction<N extends Number> extends Operation<N> {

    public Subtraction(MathOperation<N> mathOperation) {
        super(mathOperation, List.of(
                new SignRepresentation('-'),
                new NameRepresentation("subtraction")
        ), 1);
    }
    
}
