
import finance.api.domain.valueobjects.Document;
import finance.api.domain.valueobjects.DocumentFactory;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;
import finance.api.domain.valueobjects.Name;
import finance.api.domain.valueobjects.Password;

public class User{

    private enum UserType {
        CUSTOMER,
        MERCHANT
    }

    private final EntityId id;
    private final Name name;
    private final Email email;
    private final Password password;
    private Document document; // Cpf or Cnpj
    private final UserType userType;


    public User(EntityId id, Name name, Email email, Password password, Document document, UserType userType) {
        if (id == null || name == null || email == null || password == null || document == null || userType == null) {
            throw new IllegalArgumentException("User parameters cannot be null");
        }
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.document = document;
        this.userType = userType;
    }

}