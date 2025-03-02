package com.nags.calculator.impl.strToInt;

import com.nags.calculator.common.Separator;
import com.nags.calculator.expression.Expression;
import com.nags.calculator.expression.ExpressionParser;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.impl.Addition;
import com.nags.calculator.operation.impl.Division;
import com.nags.calculator.operation.impl.Multiplication;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringExpressionToIntegerParsingTest {

    @ParameterizedTest
    @MethodSource("parseExpressionCases")
    void shouldParseExpression(String stringExpression, String expectedPostfixNotation) {
        List<Operation<Integer>> supportedOperations = List.of(
                new Addition<>(new IntegerOperations.IntegerAddition()),
                new Multiplication<>(new IntegerOperations.IntegerMultiplication()),
                new Division<>(new IntegerOperations.IntegerDivision(), new IntegerOperations.IsIntegerZero()));
        ExpressionParser<String,String,Integer> parser = new ExpressionParser<>(new StringInputParser(Separator.SPACE),
                new IntegerParser(), new StringToSignParser(), supportedOperations);

        Expression<Integer> expression = parser.parseExpression(stringExpression);

        assertThat(expression.toInfixNotation()).isEqualTo(stringExpression);
        assertThat(expression.toPostfixNotation()).isEqualTo(expectedPostfixNotation);
    }

    private static Stream<Arguments> parseExpressionCases() {
        return Stream.of(
                Arguments.of("2 + 3", "2 3 +"),
                Arguments.of("6 / 3", "6 3 /"),
                Arguments.of("3 * 4", "3 4 *"),
                Arguments.of("3 * 2 + 1", "3 2 * 1 +"),
                Arguments.of("3 * -2 + 6", "3 -2 * 6 +"),
                Arguments.of("6 + 3 * -2", "6 3 -2 * +")
        );
    }

}
