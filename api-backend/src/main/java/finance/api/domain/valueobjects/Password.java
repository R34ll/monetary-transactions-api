package finance.api.domain.valueobjects;
import finance.api.domain.exceptions.*;;

public final class Password {
    private final String value;

    public Password(String value) {
        if (value == null || value.isBlank()) {
            throw new PasswordNullOrBlankException();
        }

        if (value.length() < 8) {
            throw new PasswordTooShortException();
        }

        if (!value.matches(".*[A-Z].*")) {
            throw new PasswordMissingUppercaseException();
        }

        if (!value.matches(".*[a-z].*")) {
            throw new PasswordMissingLowercaseException();
        }

        if (!value.matches(".*\\d.*")) {
            throw new PasswordMissingDigitException();
        }

        if (!value.matches(".*[!@#$%^&*()_+=\\-\\[\\]{};:'\",.<>?/\\\\|`~].*")) {
            throw new PasswordMissingSpecialCharacterException();
        }

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
