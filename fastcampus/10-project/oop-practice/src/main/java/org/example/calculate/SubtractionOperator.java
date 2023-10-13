package org.example.calculate;

public class SubtractionOperator implements NewArithmeticOperator {

    @Override
    public boolean support(final String operator) {
        return "-".equals(operator);
    }

    @Override
    public int calculate(final PositiveNumber operand1, final PositiveNumber operand2) {
        return operand1.toInt() - operand2.toInt();
    }
}
