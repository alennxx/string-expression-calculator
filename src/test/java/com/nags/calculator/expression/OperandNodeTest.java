package com.nags.calculator.expression;

import com.nags.calculator.expression.node.OperandNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandNodeTest {

    private static final Integer OPERAND_POSITIVE_VALUE = 4;
    private static final Integer OPERAND_NEGATIVE_VALUE = -6;

    @Test
    void shouldEvaluate() {
        OperandNode<Integer> operandNode = new OperandNode<>(OPERAND_POSITIVE_VALUE);

        Number evaluationResult = operandNode.evaluate();

        assertThat(evaluationResult).isEqualTo(OPERAND_POSITIVE_VALUE);
    }

    @ParameterizedTest
    @MethodSource("operandValues")
    void shouldGetValueStringAsInfixNotation(Integer value) {
        shouldGetValueStringAsNotation(value, OperandNode::toInfixNotation);
    }

    @ParameterizedTest
    @MethodSource("operandValues")
    void shouldGetValueStringAsPrefixNotation(Integer value) {
        shouldGetValueStringAsNotation(value, OperandNode::toPostfixNotation);
    }

    void shouldGetValueStringAsNotation(Integer value, Function<OperandNode<Integer>, String> notationGetter) {
        OperandNode<Integer> operandNode = new OperandNode<>(value);

        String infixNotation  = notationGetter.apply(operandNode);

        assertThat(infixNotation).isEqualTo(value.toString());
    }

    private static Stream<Integer> operandValues() {
        return Stream.of(OPERAND_POSITIVE_VALUE, OPERAND_NEGATIVE_VALUE);
    }

}
