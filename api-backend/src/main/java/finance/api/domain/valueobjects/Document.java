package finance.api.domain.valueobjects;

// // 1. Validate format (CPF or CNPJ); Normalize input (Remove punctuatino); Be immutable; Throw exception or return failure if invalid; 
public abstract class Document{
    protected final String value;

    protected Document(String value){
        this.value = normalize(value);

        if( !isValid(this.value)){
            throw new IllegalArgumentException("Invalid document format");
        }
    }

    protected abstract boolean isValid(String value);
    
    protected String normalize(String value){
        return value.replaceAll("[^\\d]","");
    }
    
    public String getValue(){
        return value;
    }
    
    public abstract String getType();


}