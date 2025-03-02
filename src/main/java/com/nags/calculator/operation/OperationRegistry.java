package com.nags.calculator.operation;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OperationRegistry<T, N extends Number> {

    private final Map<T, Operation<T,N>> operations;

    public OperationRegistry(List<Operation<T,N>> supportedOperations) {
        operations = supportedOperations.stream()
                .collect(Collectors.toMap(Operation::symbol, Function.identity()));
    }

    public boolean isSupportedOperator(T token) {
        return operations.containsKey(token);
    }

    public Operation<T,N> getOperation(T token) {
        return operations.get(token);
    }

}
