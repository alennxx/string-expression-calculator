package com.nags.calculator.operation;

public interface MathOperation<N extends Number> {
    public N apply(N a, N b);
}
