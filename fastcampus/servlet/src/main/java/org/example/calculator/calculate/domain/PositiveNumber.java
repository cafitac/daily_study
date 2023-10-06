package org.example.calculator.calculate.domain;

public class PositiveNumber {

    private final int value;

    public PositiveNumber(final int value) {
        validate(value);
        this.value = value;
    }

    private void validate(final int value) {
        if (isNegativeNumber(value)) {
            throw new IllegalArgumentException("0 또는 음수를 전달할 수 없습니다.");
        }
    }

    private boolean isNegativeNumber(final int value) {
        return value <= 0;
    }

    public int toInt() {
        return value;
    }
}
