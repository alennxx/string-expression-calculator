package com.nags.calculator.operation;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry<N extends Number> {

    private final Map<String, Operation<N>> operations;

    public OperationRegistry() {
        operations = new HashMap<>();
    }

    public void register(Operation<N> operation) {
        operations.put(operation.symbol(), operation);
    }

    public boolean isSupportedOperator(String token) {
        return operations.containsKey(token);
    }

    public Operation<N> getOperation(String token) {
        return operations.get(token);
    }

}
