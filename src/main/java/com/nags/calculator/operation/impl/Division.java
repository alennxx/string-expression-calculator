package com.nags.calculator.operation.impl;

import com.nags.calculator.operation.MathOperation;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.representation.impl.NameRepresentation;
import com.nags.calculator.operation.representation.impl.SignRepresentation;

import java.util.List;
import java.util.function.Predicate;

public class Division<N extends Number> extends Operation<N> {

    private final Predicate<N> isZeroPredicate;

    public Division(MathOperation<N> mathOperation, Predicate<N> isZero) {
        super(mathOperation, List.of(
                new SignRepresentation('/'),
                new NameRepresentation("division")
        ), 2);
        this.isZeroPredicate = isZero;
    }

    @Override
    protected boolean canBeApplied(N a, N b) {
        return isZeroPredicate.negate().test(b);
    }
}
