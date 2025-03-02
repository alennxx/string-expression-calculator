package com.nags.calculator.operation;

import com.nags.calculator.operation.representation.Representation;
import com.nags.calculator.operation.representation.RepresentationType;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class Operation<N extends Number> {
    private final MathOperation<N> mathOperation;
    private final Map<RepresentationType, Representation<?>> representations;
    private final int priority;

    public Operation(MathOperation<N> mathOperation, List<Representation<?>> representations, int priority) {
        this.mathOperation = mathOperation;
        this.representations = representations.stream()
                .collect(Collectors.toMap(Representation::getType, Function.identity()));
        this.priority = priority;
    }

    public N apply(N a, N b) {
        if (!canBeApplied(a, b)) {
            throw new InvalidOperandsForOperationException(a, b, getRepresentation(RepresentationType.SIGN));
        }
        return mathOperation.apply(a, b);
    }

    public Object getRepresentation(RepresentationType type) {
        return representations.get(type).getRepresentation();
    }

    public int getPriority() {
        return priority;
    }

    protected boolean canBeApplied(N a, N b) {
        return true;
    }

}
