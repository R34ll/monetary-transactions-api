package finance.api;

import java.util.UUID;

import finance.api.domain.entities.User;
import finance.api.domain.services.UuidGenerator;
import finance.api.domain.valueobjects.Document;
import finance.api.domain.valueobjects.DocumentFactory;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Name;
import finance.api.domain.valueobjects.Password;

public class Main {
    public static void main(String[] args) {
        EntityId cpfId = new UuidGenerator().generateId();

        Name name = new Name("John doe");
        Email email = new Email("john@doe.com");
        Password password = new Password("@securePassword123");
        Document document = DocumentFactory.create("13456338860"); // Example CPF

        User user = new User(
            cpfId,
            name,
            email,
            password,
            document,
            User.UserType.CUSTOMER
        );

        System.out.println("Hello world!");
        System.out.println(user.getId().getValue());
    }
}