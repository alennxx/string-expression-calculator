package com.nags.calculator.expression;

import com.nags.calculator.operation.representation.RepresentationType;

public interface OperatorParser<T,R> {
    R parse(T t);
    RepresentationType getRepresentationType();
}
