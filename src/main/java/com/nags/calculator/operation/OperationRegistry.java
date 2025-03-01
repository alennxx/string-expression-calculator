package com.nags.calculator.operation;

import java.util.HashMap;
import java.util.Map;

public class OperationRegistry {

    private final Map<String, Operation> operations;

    OperationRegistry() {
        operations = new HashMap<>();
    }

    void register(Operation operation) {
        operations.put(operation.symbol(), operation);
    }

    boolean isSupportedOperator(String token) {
        return operations.containsKey(token);
    }

    Operation getOperation(String token) {
        return operations.get(token);
    }

}
