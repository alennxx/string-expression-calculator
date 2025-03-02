package com.nags.calculator.expression;

import com.nags.calculator.expression.node.ExpressionNode;
import com.nags.calculator.expression.node.OperatorNode;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.representation.RepresentationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class OperatorNodeTest {

    private static final String SPACE = " ";
    private static final Integer OPERATION_RESULT = 5;
    private static final Character OPERATION_SYMBOL = '+';
    private static final Integer LEFT_OPERAND_VALUE = 1;
    private static final Integer RIGHT_OPERAND_VALUE = 4;

    private Operation<Integer> operation;
    private ExpressionNode<Integer> left;
    private ExpressionNode<Integer> right;
    private OperatorNode<String,Integer> operatorNode;

    @BeforeEach
    void setUpOperator() {
        operation = operation();
        left = token(LEFT_OPERAND_VALUE);
        right = token(RIGHT_OPERAND_VALUE);
        operatorNode = new OperatorNode<>(operation, left, right);
    }

    @Test
    void shouldEvaluate() {
        Number evaluationResult = operatorNode.evaluate();

        assertThat(evaluationResult).isEqualTo(OPERATION_RESULT);
        verify(left).evaluate();
        verify(right).evaluate();
        verify(operation).apply(LEFT_OPERAND_VALUE, RIGHT_OPERAND_VALUE);
    }

    @Test
    void shouldGetInfixNotation() {
        String infixNotation = operatorNode.toInfixNotation();

        assertThat(infixNotation).isEqualTo(LEFT_OPERAND_VALUE + SPACE
                + OPERATION_SYMBOL + SPACE + RIGHT_OPERAND_VALUE);
        verify(left).toInfixNotation();
        verify(operation).getRepresentation(RepresentationType.SIGN);
        verify(right).toInfixNotation();
    }

    @Test
    void shouldGetPostfixNotation() {
        String postfixNotation = operatorNode.toPostfixNotation();

        assertThat(postfixNotation).isEqualTo(LEFT_OPERAND_VALUE + SPACE
                + RIGHT_OPERAND_VALUE + SPACE + OPERATION_SYMBOL);
        verify(left).toPostfixNotation();
        verify(right).toPostfixNotation();
        verify(operation).getRepresentation(RepresentationType.SIGN);
    }

    private Operation<Integer> operation() {
        Operation<Integer> operation = mock(Operation.class);
        when(operation.apply(anyInt(), anyInt())).thenReturn(OPERATION_RESULT);
        when(operation.getRepresentation(any())).thenReturn(OPERATION_SYMBOL);
        return operation;
    }

    private ExpressionNode<Integer> token(Integer value) {
        ExpressionNode<Integer> expressionNode = mock(ExpressionNode.class);
        when(expressionNode.evaluate()).thenReturn(value);
        when(expressionNode.toInfixNotation()).thenReturn(value.toString());
        when(expressionNode.toPostfixNotation()).thenReturn(value.toString());
        return expressionNode;
    }

}
