package com.nags.calculator.operation;

import com.nags.calculator.expression.OperatorParser;
import com.nags.calculator.operation.representation.RepresentationType;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class OperationRegistryTest {

    private static final String OPERATION_TOKEN = "_";
    private static final Character OPERATION_SYMBOL = '_';
    private static final RepresentationType REPRESENTATION_TYPE = RepresentationType.SIGN;

    @Test
    void shouldUseOperationRepresentationDuringRegistration() {
        Operation<Integer> operation = operation();

        registry(operation);

        verify(operation).getRepresentation(REPRESENTATION_TYPE);
    }

    @Test
    void shouldNotSupportUnregisteredOperation() {
        OperationRegistry<String,Integer> registry = registry();

        boolean isSupported = registry.isSupportedOperator(OPERATION_TOKEN);

        assertThat(isSupported).isFalse();
    }

    @Test
    void shouldSupportRegisteredOperation() {
        Operation<Integer> operation = operation();
        OperationRegistry<String,Integer> registry = registry(operation);

        boolean isSupported = registry.isSupportedOperator(OPERATION_TOKEN);

        assertThat(isSupported).isTrue();
    }

    @Test
    void shouldGetRegisteredOperation() {
        Operation<Integer> operation = operation();
        OperationRegistry<String,Integer> registry = registry(operation);

        Operation<Integer> retrievedOperation = registry.getOperation(OPERATION_TOKEN);

        assertThat(retrievedOperation).isEqualTo(operation);
    }

    @Test
    void shouldNotGetUnregisteredOperation() {
        OperationRegistry<String,Integer> registry = registry();

        Operation<Integer> retrievedOperation = registry.getOperation(OPERATION_TOKEN);

        assertThat(retrievedOperation).isNull();
    }

    private OperationRegistry<String,Integer> registry(Operation<Integer> operation) {
        return new OperationRegistry<>(operatorParser(), List.of(operation));
    }

    private OperationRegistry<String,Integer> registry() {
        return new OperationRegistry<>(operatorParser(), Collections.emptyList());
    }

    private Operation<Integer> operation() {
        Operation<Integer> operation = mock(Operation.class);
        when(operation.getRepresentation(any())).thenReturn(OPERATION_SYMBOL);
        return operation;
    }

    private OperatorParser<String,Character> operatorParser() {
        OperatorParser<String,Character> parser = mock(OperatorParser.class);
        when(parser.getRepresentationType()).thenReturn(REPRESENTATION_TYPE);
        when(parser.parse(anyString())).thenReturn(OPERATION_SYMBOL);
        return parser;
    }

}
