package org.example.calculator.calculate.tobe;

import org.example.calculator.calculate.domain.PositiveNumber;

public class SubtractionOperator implements ArithmeticOperator {

    @Override
    public boolean support(final String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(final PositiveNumber operand1, final PositiveNumber operand2) {
        return operand1.toInt() - operand2.toInt();
    }
}
