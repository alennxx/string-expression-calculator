package com.nags.calculator.operation;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry<T, N extends Number> {

    private final Map<T, Operation<T,N>> operations;

    public OperationRegistry() {
        operations = new HashMap<>();
    }

    public void register(Operation<T,N> operation) {
        operations.put(operation.symbol(), operation);
    }

    public boolean isSupportedOperator(T token) {
        return operations.containsKey(token);
    }

    public Operation<T,N> getOperation(T token) {
        return operations.get(token);
    }

}
