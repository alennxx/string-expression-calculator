package com.nags.calculator.operation.representation;

public abstract class BaseRepresentation<T> implements Representation<T> {
    private final T representation;
    private final RepresentationType representationType;

    protected BaseRepresentation(T representation, RepresentationType representationType) {
        this.representation = representation;
        this.representationType = representationType;
    }

    @Override
    public T getRepresentation() {
        return representation;
    }

    @Override
    public RepresentationType getType() {
        return representationType;
    }
}
