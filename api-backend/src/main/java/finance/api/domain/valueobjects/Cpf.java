package finance.api.domain.valueobjects;

import finance.api.domain.exceptions.*;

public class Cpf extends Document {

    public Cpf(String cpf) {
        super(validate(cpf)); // TODO: executa validação antes de chamar super. FIX
    }

    private static String validate(String value) {
        if (value == null || value.isBlank()) {
            throw new CpfNullOrBlankException("CPF cannot be null or blank");
        }
        return value;
    }

    @Override
    protected boolean isValid(String value) {
        String sanitized = value.replaceAll("\\D", "");

        if (!sanitized.matches("\\d{11}")) {
            throw new CpfInvalidLengthException("CPF must contain exactly 11 digits");
        }

        if (sanitized.chars().distinct().count() == 1) {
            throw new CpfAllDigitsEqualException("CPF cannot have all digits equal");
        }

        return true;
    }

    @Override
    public String getType() {
        return "CPF";
    }
}
