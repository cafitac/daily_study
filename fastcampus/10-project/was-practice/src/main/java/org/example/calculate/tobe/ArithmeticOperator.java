package org.example.calculate.tobe;

import org.example.calculate.domain.PositiveNumber;

public interface ArithmeticOperator {

    boolean support(String operator);

    int calculate(PositiveNumber operand1, PositiveNumber operand2);
}
