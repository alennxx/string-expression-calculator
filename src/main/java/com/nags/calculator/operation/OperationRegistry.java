package com.nags.calculator.operation;

import com.nags.calculator.expression.OperatorParser;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OperationRegistry<T, N extends Number> {

    private final Map<?,Operation<N>> operations;
    private final OperatorParser<T,?> operatorParser;

    public OperationRegistry(OperatorParser<T,?> operatorParser,
                             List<Operation<N>> supportedOperations) {
        this.operatorParser = operatorParser;
        operations = supportedOperations.stream()
                .collect(Collectors.toMap(
                        op -> op.getRepresentation(operatorParser.getRepresentationType()),
                        Function.identity()));
    }

    public boolean isSupportedOperator(T token) {
        if (operatorParser == null) {
            return false;
        }
        return operations.containsKey(operatorParser.parse(token));
    }

    public Operation<N> getOperation(T token) {
        return operations.get(operatorParser.parse(token));
    }

}
