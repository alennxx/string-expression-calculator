package com.nags.calculator.operation;

public record Operation<N extends Number>(MathOperation<N> mathOperation, String symbol, int priority) {
    public N apply(N a, N b) {
        return mathOperation.apply(a, b);
    }
}
