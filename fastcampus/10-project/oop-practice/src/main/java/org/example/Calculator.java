package org.example;

import java.util.List;
import org.example.calculate.AdditionOperator;
import org.example.calculate.DivisionOperator;
import org.example.calculate.MultiplicationOperator;
import org.example.calculate.NewArithmeticOperator;
import org.example.calculate.PositiveNumber;
import org.example.calculate.SubtractionOperator;

public class Calculator {

    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(
        new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(),
        new DivisionOperator());

    public static int calculate(final PositiveNumber operand1, final String operator, final PositiveNumber operand2) {
        return arithmeticOperators.stream()
            .filter(arithmeticOperator -> arithmeticOperator.support(operator))
            .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
