package com.nags.calculator.expression;

import com.nags.calculator.operation.Operation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class OperatorTest {

    private static final String SPACE = " ";
    private static final Integer OPERATION_RESULT = 5;
    private static final String OPERATION_SYMBOL = "+";
    private static final Integer LEFT_OPERAND_VALUE = 1;
    private static final Integer RIGHT_OPERAND_VALUE = 4;

    private Operation operation;
    private Token left;
    private Token right;
    private Operator operator;

    @BeforeEach
    void setUpOperator() {
        operation = operation();
        left = token(LEFT_OPERAND_VALUE);
        right = token(RIGHT_OPERAND_VALUE);
        operator = new Operator(operation, left, right);
    }

    @Test
    void shouldEvaluate() {
        Integer evaluationResult = operator.evaluate();

        assertThat(evaluationResult).isEqualTo(OPERATION_RESULT);
        verify(left).evaluate();
        verify(right).evaluate();
        verify(operation).apply(LEFT_OPERAND_VALUE, RIGHT_OPERAND_VALUE);
    }

    @Test
    void shouldGetInfixNotation() {
        String infixNotation = operator.toInfixNotation();

        assertThat(infixNotation).isEqualTo(LEFT_OPERAND_VALUE + SPACE
                + OPERATION_SYMBOL + SPACE + RIGHT_OPERAND_VALUE);
        verify(left).toInfixNotation();
        verify(operation).symbol();
        verify(right).toInfixNotation();
    }

    @Test
    void shouldGetPostfixNotation() {
        String postfixNotation = operator.toPostfixNotation();

        assertThat(postfixNotation).isEqualTo(LEFT_OPERAND_VALUE + SPACE
                + RIGHT_OPERAND_VALUE + SPACE + OPERATION_SYMBOL);
        verify(left).toPostfixNotation();
        verify(right).toPostfixNotation();
        verify(operation).symbol();
    }

    private Operation operation() {
        Operation operation = mock(Operation.class);
        when(operation.apply(anyInt(), anyInt())).thenReturn(OPERATION_RESULT);
        when(operation.symbol()).thenReturn(OPERATION_SYMBOL);
        return operation;
    }

    private Token token(Integer value) {
        Token token = mock(Token.class);
        when(token.evaluate()).thenReturn(value);
        when(token.toInfixNotation()).thenReturn(value.toString());
        when(token.toPostfixNotation()).thenReturn(value.toString());
        return token;
    }

}
