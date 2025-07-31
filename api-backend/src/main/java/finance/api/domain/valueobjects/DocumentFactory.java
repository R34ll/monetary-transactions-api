package finance.api.domain.valueobjects;

public class DocumentFactory {
    public static Document create(String value){

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Document cannot be null or empty");
        }


        String cleaned = value.replaceAll("[^\\d]", "");

        if(cleaned.length() == 11) {
            return new Cpf(value);
        } else if (cleaned.length() == 14) {
            return new Cnpj(value);
        } else {
            throw new IllegalArgumentException("Invalid document length. Must be 11 digits for CPF or 14 digits for CNPJ.");
        }

    }
}


