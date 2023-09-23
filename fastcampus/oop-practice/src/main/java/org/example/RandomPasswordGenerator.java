package org.example;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class RandomPasswordGenerator implements org.example.PasswordGenerator {

    /**
     * Special characters allowed in password.
     */
    public static final String ALLOWED_SPL_CHARACTERS = "!@#$%^&*()_+";

    public static final String ERROR_CODE = "ERRONEOUS_SPECIAL_CHARS";

    @Override
    public String generatePassword() {
        final PasswordGenerator gen = new PasswordGenerator();

        final CharacterData lowerCase = EnglishCharacterData.LowerCase;
        final CharacterRule lowerCaseRule = new CharacterRule(lowerCase);
        lowerCaseRule.setNumberOfCharacters(2);

        final CharacterData upperCase = EnglishCharacterData.UpperCase;
        final CharacterRule upperCaseRule = new CharacterRule(upperCase);
        upperCaseRule.setNumberOfCharacters(2);

        final CharacterData digitCase = EnglishCharacterData.Digit;
        final CharacterRule digitRule = new CharacterRule(digitCase);
        digitRule.setNumberOfCharacters(2);

        final CharacterData specialChars = new CharacterData() {

            @Override
            public String getErrorCode() {
                return ERROR_CODE;
            }

            @Override
            public String getCharacters() {
                return ALLOWED_SPL_CHARACTERS;
            }
        };
        final CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        // 0 - 12
        return gen.generatePassword((int) (Math.random() * 12), splCharRule, lowerCaseRule,
            upperCaseRule, digitRule);
    }
}
