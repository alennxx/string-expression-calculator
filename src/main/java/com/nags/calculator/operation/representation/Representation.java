package com.nags.calculator.operation.representation;

public interface Representation<R> {
    R getRepresentation();
    RepresentationType getType();
}
