package com.nags.calculator.operation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class OperationRegistryTest {

    private static final String OPERATION_SYMBOL = "_";

    @Test
    void shouldUseOperationSymbolDuringRegistration() {
        Operation<String,Integer> operation = operation();

        registry(operation);

        verify(operation).symbol();
    }

    @Test
    void shouldNotSupportUnregisteredOperation() {
        OperationRegistry<String,Integer> registry = registry();

        boolean isSupported = registry.isSupportedOperator(OPERATION_SYMBOL);

        assertThat(isSupported).isFalse();
    }

    @Test
    void shouldSupportRegisteredOperation() {
        Operation<String,Integer> operation = operation();
        OperationRegistry<String,Integer> registry = registry(operation);

        boolean isSupported = registry.isSupportedOperator(operation.symbol());

        assertThat(isSupported).isTrue();
    }

    @Test
    void shouldGetRegisteredOperation() {
        Operation<String,Integer> operation = operation();
        OperationRegistry<String,Integer> registry = registry(operation);

        Operation<String,Integer> retrievedOperation = registry.getOperation(operation.symbol());

        assertThat(retrievedOperation).isEqualTo(operation);
    }

    @Test
    void shouldNotGetUnregisteredOperation() {
        OperationRegistry<String,Integer> registry = registry();

        Operation<String,Integer> retrievedOperation = registry.getOperation(OPERATION_SYMBOL);

        assertThat(retrievedOperation).isNull();
    }

    private OperationRegistry<String,Integer> registry(Operation<String,Integer> operation) {
        OperationRegistry<String,Integer> registry = registry();
        registry.register(operation);
        return registry;
    }

    private OperationRegistry<String,Integer> registry() {
        return new OperationRegistry<>();
    }

    private Operation<String,Integer> operation() {
        Operation<String,Integer> operation = mock(Operation.class);
        when(operation.symbol()).thenReturn(OPERATION_SYMBOL);
        return operation;
    }

}
