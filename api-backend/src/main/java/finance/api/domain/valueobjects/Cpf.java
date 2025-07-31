package finance.api.domain.valueobjects;
/**
 * Represents a CPF (Cadastro de Pessoas Físicas) document.
 * This class extends the Document class and provides validation specific to CPF.
 */
public class Cpf extends Document{
    public Cpf(String value){
        super(value);
    }

    @Override
    protected boolean isValid(String value){
        if( value == null || value.isBlank()) {
            throw new IllegalArgumentException("CPF cannot be null or blank");
        }

        if (!value.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF must contain exactly 11 digits");
        }

        if (value.chars().distinct().count() == 1) {
            throw new IllegalArgumentException("CPF cannot have all digits equal");
        }

        return true;
    }
    

    @Override
    public String getType() {
        return "CPF";
    }
}
