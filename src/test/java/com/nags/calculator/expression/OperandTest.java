package com.nags.calculator.expression;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperandTest implements TokenTest {

    private static final Integer OPERAND_VALUE = -1;

    @Test
    @Override
    public void shouldEvaluate() {
        Operand operand = new Operand(OPERAND_VALUE);

        Integer evaluationResult = operand.evaluate();

        assertThat(evaluationResult).isEqualTo(OPERAND_VALUE);
    }

}
