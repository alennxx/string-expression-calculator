package com.nags.calculator.operation;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {

    private final Map<String, Operation> operations;

    public OperationRegistry() {
        operations = new HashMap<>();
    }

    public void register(Operation operation) {
        operations.put(operation.symbol(), operation);
    }

    public boolean isSupportedOperator(String token) {
        return operations.containsKey(token);
    }

    public Operation getOperation(String token) {
        return operations.get(token);
    }

}
