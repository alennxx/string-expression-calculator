package com.nags.calculator.expression;

import com.nags.calculator.common.Separator;
import com.nags.calculator.strToInt.IntegerOperations;
import com.nags.calculator.strToInt.IntegerParser;
import com.nags.calculator.strToInt.StringInputParser;
import com.nags.calculator.operation.Operation;
import com.nags.calculator.operation.OperationRegistry;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ExpressionParserTest {

    @ParameterizedTest
    @MethodSource("parseExpressionCases")
    void shouldParseExpression(String stringExpression, String expectedPostfixNotation) {
        OperationRegistry<String,Integer> registry = new OperationRegistry<>();
        registry.register(new Operation<>(new IntegerOperations.IntegerAddition(), "+", 1));
        registry.register(new Operation<>(new IntegerOperations.IntegerMultiplication(), "*", 2));
        registry.register(new Operation<>(new IntegerOperations.IntegerDivision(), "/", 2));
        ExpressionParser<String,String,Integer> parser = new ExpressionParser<>(new StringInputParser(Separator.SPACE),
                new IntegerParser(), registry);

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
