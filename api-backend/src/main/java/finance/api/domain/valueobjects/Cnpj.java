package finance.api.domain.valueobjects;

public class Cnpj extends Document {

    public Cnpj(String cnpj) {
        super(cnpj);
    }

    @Override
    protected boolean isValid(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("CNPJ cannot be null or blank");
        }

        String sanitized = value.replaceAll("\\D", "");

        if (!sanitized.matches("\\d{14}")) {
            throw new IllegalArgumentException("CNPJ must contain exactly 14 digits");
        }

        if (sanitized.chars().distinct().count() == 1) {
            throw new IllegalArgumentException("CNPJ cannot have all digits equal");
        }

        return true;
    }
    
    @Override
    public String getType() {
        return "CNPJ";
    }

}
