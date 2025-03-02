package com.nags.calculator.operation;

public record Operation<T,N extends Number>(MathOperation<N> mathOperation, T symbol, int priority) {
    public N apply(N a, N b) {
        return mathOperation.apply(a, b);
    }
}
