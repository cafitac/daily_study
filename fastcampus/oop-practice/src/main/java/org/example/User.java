package org.example;

public class User {

    private String password;

    public void initPassword(final PasswordGenerator passwordGenerator) {
        final String randomPassword = passwordGenerator.generatePassword();
        /**
         * 비밀번호는 최소 8자 이상 12 자 이하여야 한다.
         */
        if (randomPassword.length() >= 8 && randomPassword.length() <= 12) {
            this.password = randomPassword;
        }
    }

    public String getPassword() {
        return password;
    }
}
