public final class Cnpj {
    private final String cnpj;

    public Cnpj(String cnpj) {
        if (cnpj == null || cnpj.isBlank()) {
            throw new IllegalArgumentException("CNPJ cannot be null or blank");
        }

        String sanitized = cnpj.replaceAll("\\D", "");

        if (!sanitized.matches("\\d{14}")) {
            throw new IllegalArgumentException("CNPJ must contain exactly 14 digits");
        }

        if (sanitized.chars().distinct().count() == 1) {
            throw new IllegalArgumentException("CNPJ cannot have all digits equal");
        }

        // if (!isValidCnpj(sanitized)) {
        //     throw new IllegalArgumentException("Invalid CNPJ");
        // }

        this.cnpj = cnpj;
    }

    // TODO: Implement CNPJ validation logic
    private boolean isValidCnpj(String cnpj) {
        return false;
    }

    public String getValue() {
        return cnpj;
    }
}