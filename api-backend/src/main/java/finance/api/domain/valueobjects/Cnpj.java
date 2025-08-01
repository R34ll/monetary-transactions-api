package finance.api.domain.valueobjects;

import finance.api.domain.exceptions.*;

public class Cnpj extends Document {

    public Cnpj(String cnpj) {
        super(validate(cnpj)); 
    }

    private static String validate(String value) {
        if (value == null || value.isBlank()) {
            throw new CnpjNullOrBlankException();
        }
        return value;
    }

    @Override
    protected boolean isValid(String value) {
        String sanitized = value.replaceAll("\\D", "");

        if (!sanitized.matches("\\d{14}")) {
            throw new CnpjInvalidLengthException();
        }

        if (sanitized.chars().distinct().count() == 1) {
            throw new CnpjAllDigitsEqualException();
        }

        return true;
    }

    @Override
    public String getType() {
        return "CNPJ";
    }
}
