package com.nags.calculator.expression;

import com.nags.calculator.operation.Operation;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class OperatorTest implements TokenTest {

    private static final Integer OPERATION_RESULT = 5;
    private static final Integer LEFT_OPERAND_VALUE = 1;
    private static final Integer RIGHT_OPERAND_VALUE = 4;

    @Test
    @Override
    public void shouldEvaluate() {
        Operation operation = operation();
        Token left = token(LEFT_OPERAND_VALUE);
        Token right = token(RIGHT_OPERAND_VALUE);
        Operator operator = new Operator(operation, left, right);

        Integer evaluationResult = operator.evaluate();

        assertThat(evaluationResult).isEqualTo(OPERATION_RESULT);

        verify(left).evaluate();
        verify(right).evaluate();
        verify(operation).apply(LEFT_OPERAND_VALUE, RIGHT_OPERAND_VALUE);
    }

    private Operation operation() {
        Operation operation = mock(Operation.class);
        when(operation.apply(anyInt(), anyInt())).thenReturn(OPERATION_RESULT);
        return operation;
    }

    private Token token(Integer value) {
        Token token = mock(Token.class);
        when(token.evaluate()).thenReturn(value);
        return token;
    }

}
