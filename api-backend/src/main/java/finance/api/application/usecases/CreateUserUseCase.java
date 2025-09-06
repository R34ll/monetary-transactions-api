package finance.api.application.usecases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import finance.api.domain.entities.User;
import finance.api.domain.entities.User.UserType;
import finance.api.domain.exceptions.UserDocumentAlreadyExistsException;
import finance.api.domain.exceptions.UserEmailAlreadyExistsException;
import finance.api.domain.repository.UserRepository;
import finance.api.domain.services.IdGenerator;
import finance.api.domain.valueobjects.DocumentFactory;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.Name;
import finance.api.domain.valueobjects.Password;
import finance.api.domain.valueobjects.Document;


@Service
public class CreateUserUseCase {
    private UserRepository userRepository;
    private final IdGenerator idGenerator;

    @Autowired
    public CreateUserUseCase(UserRepository userRepository, IdGenerator idGenerator) {
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    public User execute(String name, String email, String password, String documentNumber, User.UserType userType) { // TODO: AccountType

        Name userName = new Name(name);
        Email userEmail = new Email(email);
        Password userPassword = new Password(password);
        Document document = DocumentFactory.create(documentNumber);
        User.UserType type = userType;

        // Check if user already exists
        if(userRepository.findByEmail(userEmail) != null){
            throw new UserEmailAlreadyExistsException();
        }

        if(userRepository.findByDocument(document) != null){
            throw new UserDocumentAlreadyExistsException();
        }

        User user = new User(
            idGenerator.generateId(),
            userName,
            userEmail,
            userPassword,
            document,
            type
        );


        return userRepository.save(user);
    }
}
