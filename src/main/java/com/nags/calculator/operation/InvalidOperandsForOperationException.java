package com.nags.calculator.operation;

public class InvalidOperandsForOperationException extends RuntimeException {
    public InvalidOperandsForOperationException(Number a, Number b, Object operationRepresentation) {
        super("Operands: " + a + ", " + b + " are invalid for '" + operationRepresentation + "' operation");
    }

}
