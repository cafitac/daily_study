package org.example.calculate;

public class DivisionOperator implements NewArithmeticOperator {

    @Override
    public boolean support(final String operator) {
        return "/".equals(operator);
    }

    @Override
    public int calculate(final int operand1, final int operand2) {
        return operand1 / operand2;
    }
}
