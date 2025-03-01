package com.nags.calculator.operation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class OperationRegistryTest {

    private static final String OPERATION_SYMBOL = "_";

    @Test
    void shouldUseOperationSymbolDuringRegistration() {
        Operation operation = operation();

        registry(operation);

        verify(operation).symbol();
    }

    @Test
    void shouldNotSupportUnregisteredOperation() {
        OperationRegistry registry = registry();

        boolean isSupported = registry.isSupportedOperator(OPERATION_SYMBOL);

        assertThat(isSupported).isFalse();
    }

    @Test
    void shouldSupportRegisteredOperation() {
        Operation operation = operation();
        OperationRegistry registry = registry(operation);

        boolean isSupported = registry.isSupportedOperator(operation.symbol());

        assertThat(isSupported).isTrue();
    }

    @Test
    void shouldGetRegisteredOperation() {
        Operation operation = operation();
        OperationRegistry registry = registry(operation);

        Operation retrievedOperation = registry.getOperation(operation.symbol());

        assertThat(retrievedOperation).isEqualTo(operation);
    }

    @Test
    void shouldNotGetUnregisteredOperation() {
        OperationRegistry registry = registry();

        Operation retrievedOperation = registry.getOperation(OPERATION_SYMBOL);

        assertThat(retrievedOperation).isNull();
    }

    private OperationRegistry registry(Operation... operations) {
        OperationRegistry registry = registry();
        for (Operation operation : operations) {
            registry.register(operation);
        }
        return registry;
    }

    private OperationRegistry registry() {
        return new OperationRegistry();
    }

    private Operation operation() {
        Operation operation = mock(Operation.class);
        when(operation.symbol()).thenReturn(OPERATION_SYMBOL);
        return operation;
    }

}
