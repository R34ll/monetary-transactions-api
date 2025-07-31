package finance.api.domain.valueobjects;

public class Name{
    private final String name;

    public Name(String name){
        
        // 1. Must not be null or blank (ensures the name has meaningful content)

        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or blank.");
        }

        // 2. Must not exceed 250 characters (protects against overly long input and possible misuse)

        if(name.length() > 250){
            throw new IllegalArgumentException("Name cannot be longer than 250 characters.");
        }

        // 3. Must not contain special characters (only letters and spaces are allowed)
        //    This prevents usage of symbols like @, #, !, etc., which are not valid in personal names
         // 4. Must not contain numbers (ensures name is composed only of alphabetic characters)
        if(!name.matches("^[A-Za-zÀ-ÿ\\s]+$")){
            throw new IllegalArgumentException("Name must not contain numbers or special characters.");
        }


        this.name = name.trim();

    }


    public String getValue(){
        return name;
    }

    @Override
    public String toString(){
        return name;
    }




}