package org.example.calculator.calculate.domain;

import java.util.List;
import org.example.calculator.calculate.tobe.AdditionOperator;
import org.example.calculator.calculate.tobe.ArithmeticOperator;
import org.example.calculator.calculate.tobe.DivisionOperator;
import org.example.calculator.calculate.tobe.SubtractionOperator;

public class Calculator {

    private static final List<ArithmeticOperator> arithmeticOperators = List.of(
        new AdditionOperator(), new SubtractionOperator(), new DivisionOperator());

    public static int calculate(final PositiveNumber operand1, final String operator, final PositiveNumber operand2) {
        return arithmeticOperators.stream()
            .filter(arithmeticOperator -> arithmeticOperator.support(operator))
            .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
