public final class Cpf{
    private final String cpf;

    public Cpf(String cpf){
        
        // 1. Check if the input is null or blank
        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException("CPF cannot be null or blank");
        }

        // 2. Remove non-digit characters and validate the length xxx.xxx.xxx-xx to xxxxxxxxxxx
        String sanitized = cpf.replaceAll("\\D", "");

        // 3. Validate the sanitized CPF
        if (!sanitized.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF must contain exactly 11 digits");
        }

        // 4. Check if the CPF has all digits equal (e.g., 111.111.111-11)
        if (sanitized.chars().distinct().count() == 1) {
            throw new IllegalArgumentException("CPF cannot have all digits equal");
        }

        // 5. Validate the CPF using a checksum algorithm
        if (!isValidCpf(sanitized)) {
            throw new IllegalArgumentException("Invalid CPF");
        }


        this.cpf = cpf;
    }

    // TODO: implement the CPF validation logic used by government
    private boolean isValidCpf(String cpf){
        return false;
    }

    public String getValue() {
        return cpf;
    }

}