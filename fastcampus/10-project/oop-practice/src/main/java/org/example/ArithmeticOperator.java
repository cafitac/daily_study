package org.example;

import java.util.Arrays;

public enum ArithmeticOperator {
    ADDITION("+") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 + operand2;
        }
    }, SUBTRACTION("-") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 - operand2;
        }
    }, MULTIPLICATION("*") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 * operand2;
        }
    }, DIVISION("/") {
        @Override
        public int arithmeticCalculate(final int operand1, final int operand2) {
            return operand1 / operand2;
        }
    };

    private final String operator;

    ArithmeticOperator(final String operator) {
        this.operator = operator;
    }

    protected abstract int arithmeticCalculate(final int operand1, final int operand2);

    public static int calculate(final int operand1, final String operator, final int operand2) {
        final ArithmeticOperator arithmeticOperator = Arrays.stream(values())
            .filter(v -> v.operator.equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));

        return arithmeticOperator.arithmeticCalculate(operand1, operand2);
    }
}
