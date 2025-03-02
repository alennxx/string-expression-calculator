package com.nags.calculator.operation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class OperationRegistryTest {

    private static final String OPERATION_SYMBOL = "_";

    @Test
    void shouldUseOperationSymbolDuringRegistration() {
        Operation<Integer> operation = operation();

        registry(operation);

        verify(operation).symbol();
    }

    @Test
    void shouldNotSupportUnregisteredOperation() {
        OperationRegistry<Integer> registry = registry();

        boolean isSupported = registry.isSupportedOperator(OPERATION_SYMBOL);

        assertThat(isSupported).isFalse();
    }

    @Test
    void shouldSupportRegisteredOperation() {
        Operation<Integer> operation = operation();
        OperationRegistry<Integer> registry = registry(operation);

        boolean isSupported = registry.isSupportedOperator(operation.symbol());

        assertThat(isSupported).isTrue();
    }

    @Test
    void shouldGetRegisteredOperation() {
        Operation<Integer> operation = operation();
        OperationRegistry<Integer> registry = registry(operation);

        Operation<Integer> retrievedOperation = registry.getOperation(operation.symbol());

        assertThat(retrievedOperation).isEqualTo(operation);
    }

    @Test
    void shouldNotGetUnregisteredOperation() {
        OperationRegistry<Integer> registry = registry();

        Operation<Integer> retrievedOperation = registry.getOperation(OPERATION_SYMBOL);

        assertThat(retrievedOperation).isNull();
    }

    private OperationRegistry<Integer> registry(Operation<Integer> operation) {
        OperationRegistry<Integer> registry = registry();
        registry.register(operation);
        return registry;
    }

    private OperationRegistry<Integer> registry() {
        return new OperationRegistry<>();
    }

    private Operation<Integer> operation() {
        Operation<Integer> operation = mock(Operation.class);
        when(operation.symbol()).thenReturn(OPERATION_SYMBOL);
        return operation;
    }

}
