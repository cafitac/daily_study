package org.example.calculator.calculate.tobe;

import org.example.calculator.calculate.domain.PositiveNumber;

public interface ArithmeticOperator {

    boolean support(String operator);

    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
