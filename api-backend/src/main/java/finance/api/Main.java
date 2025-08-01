package finance.api;

import java.util.UUID;

import finance.api.domain.entities.User;
import finance.api.domain.valueobjects.Cpf;
import finance.api.domain.valueobjects.Document;
import finance.api.domain.valueobjects.DocumentFactory;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Name;
import finance.api.domain.valueobjects.Password;

public class Main {
    public static void main(String[] args) {
        EntityId cpfId = new EntityId(UUID.randomUUID());

        Name name = new Name("John doe");
        Email email = new Email("john@doe.com");
        Password password = new Password("@securePassword123");
        Document document = DocumentFactory.create("13456338860"); // Assuming DocumentFactory is implemented

        User user = new User(
            cpfId,
            name,
            email,
            password,
            document,
            User.UserType.CUSTOMER
        );

        System.out.println("Hello world!");
    }
}