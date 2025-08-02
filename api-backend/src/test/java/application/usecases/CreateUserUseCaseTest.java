package application.usecases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import finance.api.application.usecases.CreateUserUseCase;
import finance.api.domain.entities.User;
import finance.api.domain.entities.User.UserType;
import finance.api.domain.exceptions.*;
import finance.api.domain.repository.UserRepository;
import finance.api.domain.services.IdGenerator;
import finance.api.domain.valueobjects.*;

class CreateUserUseCaseTest {

    @Mock
    private UserRepository userRepository;
    
    @Mock
    private IdGenerator idGenerator;
    
    private CreateUserUseCase createUserUseCase;
    
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createUserUseCase = new CreateUserUseCase(userRepository, idGenerator);
    }

    @Test
    @DisplayName("Should create user successfully with valid data")
    void shouldCreateUserSuccessfully() {
        // Arrange
        String name = "João Silva";
        String email = "joao@email.com";
        String password = "Password123!";
        String documentNumber = "12345678901"; // CPF
        
        EntityId generatedId = new EntityId("user-123");
        when(idGenerator.generateId()).thenReturn(generatedId);
        when(userRepository.findByEmail(any(Email.class))).thenReturn(null);
        when(userRepository.findByDocument(any(Document.class))).thenReturn(null);
        
        User savedUser = new User(
            generatedId,
            new Name(name),
            new Email(email),
            new Password(password),
            DocumentFactory.create(documentNumber),
            UserType.CUSTOMER
        );
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        
        // Act
        User result = createUserUseCase.execute(name, email, password, documentNumber);
        
        // Assert
        assertNotNull(result);
        assertEquals(generatedId, result.getId());
        assertEquals(name, result.getName().getValue());
        assertEquals(email, result.getEmail().getValue());
        assertEquals(UserType.CUSTOMER, result.getUserType());
        
        verify(userRepository).findByEmail(any(Email.class));
        verify(userRepository).findByDocument(any(Document.class));
        verify(userRepository).save(any(User.class));
        verify(idGenerator).generateId();
    }

    @Test
    @DisplayName("Should create user with CNPJ document")
    void shouldCreateUserWithCnpj() {
        // Arrange
        String name = "Empresa LTDA";
        String email = "empresa@email.com";
        String password = "Password123!";
        String documentNumber = "12345678000195"; // CNPJ
        
        EntityId generatedId = new EntityId("user-456");
        when(idGenerator.generateId()).thenReturn(generatedId);
        when(userRepository.findByEmail(any(Email.class))).thenReturn(null);
        when(userRepository.findByDocument(any(Document.class))).thenReturn(null);
        
        User savedUser = new User(
            generatedId,
            new Name(name),
            new Email(email),
            new Password(password),
            DocumentFactory.create(documentNumber),
            UserType.CUSTOMER
        );
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        
        // Act
        User result = createUserUseCase.execute(name, email, password, documentNumber);
        
        // Assert
        assertNotNull(result);
        assertTrue(result.getDocument() instanceof Cnpj);
    }

    @Test
    @DisplayName("Should throw exception when email already exists")
    void shouldThrowExceptionWhenEmailAlreadyExists() {
        // Arrange
        String name = "João Silva";
        String email = "joao@email.com";
        String password = "Password123!";
        String documentNumber = "12345678901";
        
        User existingUser = mock(User.class);
        when(userRepository.findByEmail(any(Email.class))).thenReturn(existingUser);
        
        // Act & Assert
        assertThrows(UserEmailAlreadyExistsException.class, () -> {
            createUserUseCase.execute(name, email, password, documentNumber);
        });
        
        verify(userRepository).findByEmail(any(Email.class));
        verify(userRepository, never()).findByDocument(any(Document.class));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception when document already exists")
    void shouldThrowExceptionWhenDocumentAlreadyExists() {
        // Arrange
        String name = "João Silva";
        String email = "joao@email.com";
        String password = "Password123!";
        String documentNumber = "12345678901";
        
        User existingUser = mock(User.class);
        when(userRepository.findByEmail(any(Email.class))).thenReturn(null);
        when(userRepository.findByDocument(any(Document.class))).thenReturn(existingUser);
        
        // Act & Assert
        assertThrows(UserDocumentAlreadyExistsException.class, () -> {
            createUserUseCase.execute(name, email, password, documentNumber);
        });
        
        verify(userRepository).findByEmail(any(Email.class));
        verify(userRepository).findByDocument(any(Document.class));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception for invalid name")
    void shouldThrowExceptionForInvalidName() {
        // Arrange
        String invalidName = ""; // Empty name
        String email = "joao@email.com";
        String password = "Password123!";
        String documentNumber = "12345678901";
        
        // Act & Assert
        assertThrows(NameNullOrBlankException.class, () -> {
            createUserUseCase.execute(invalidName, email, password, documentNumber);
        });
        
        verify(userRepository, never()).findByEmail(any(Email.class));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception for invalid email")
    void shouldThrowExceptionForInvalidEmail() {
        // Arrange
        String name = "João Silva";
        String invalidEmail = "invalid-email";
        String password = "Password123!";
        String documentNumber = "12345678901";
        
        // Act & Assert
        assertThrows(EmailInvalidFormatException.class, () -> {
            createUserUseCase.execute(name, invalidEmail, password, documentNumber);
        });
        
        verify(userRepository, never()).findByEmail(any(Email.class));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception for invalid password")
    void shouldThrowExceptionForInvalidPassword() {
        // Arrange
        String name = "João Silva";
        String email = "joao@email.com";
        String invalidPassword = "123"; // Too short
        String documentNumber = "12345678901";
        
        // Act & Assert
        assertThrows(PasswordTooShortException.class, () -> {
            createUserUseCase.execute(name, email, invalidPassword, documentNumber);
        });
        
        verify(userRepository, never()).findByEmail(any(Email.class));
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    @DisplayName("Should throw exception for invalid document")
    void shouldThrowExceptionForInvalidDocument() {
        // Arrange
        String name = "João Silva";
        String email = "joao@email.com";
        String password = "Password123!";
        String invalidDocument = "123"; // Invalid length
        
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> {
            createUserUseCase.execute(name, email, password, invalidDocument);
        });
        
        verify(userRepository, never()).findByEmail(any(Email.class));
        verify(userRepository, never()).save(any(User.class));
    }

    // # TODO: Create EmailNullOrBlankException
    // @Test
    // @DisplayName("Should throw exception for null inputs")
    // void shouldThrowExceptionForNullInputs() {
    //     // Act & Assert
    //     assertThrows(NameNullOrBlankException.class, () -> {
    //         createUserUseCase.execute(null, "email@test.com", "Password123!", "12345678901");
    //     });
        
    //     assertThrows(EmailNullOrBlankException.class, () -> {
    //         createUserUseCase.execute("João Silva", null, "Password123!", "12345678901");
    //     });
        
    //     assertThrows(PasswordNullOrBlankException.class, () -> {
    //         createUserUseCase.execute("João Silva", "email@test.com", null, "12345678901");
    //     });
        
    //     assertThrows(IllegalArgumentException.class, () -> {
    //         createUserUseCase.execute("João Silva", "email@test.com", "Password123!", null);
    //     });
    // }

    @Test
    @DisplayName("Should validate name with special characters")
    void shouldValidateNameWithSpecialCharacters() {
        // Arrange
        String nameWithNumbers = "João123";
        String email = "joao@email.com";
        String password = "Password123!";
        String documentNumber = "12345678901";
        
        // Act & Assert
        assertThrows(NameInvalidCharactersException.class, () -> {
            createUserUseCase.execute(nameWithNumbers, email, password, documentNumber);
        });
    }

    @Test
    @DisplayName("Should validate name with accented characters")
    void shouldAcceptNameWithAccentedCharacters() {
        // Arrange
        String name = "José da Silva Ção";
        String email = "jose@email.com";
        String password = "Password123!";
        String documentNumber = "12345678901";
        
        EntityId generatedId = new EntityId("user-789");
        when(idGenerator.generateId()).thenReturn(generatedId);
        when(userRepository.findByEmail(any(Email.class))).thenReturn(null);
        when(userRepository.findByDocument(any(Document.class))).thenReturn(null);
        
        User savedUser = new User(
            generatedId,
            new Name(name),
            new Email(email),
            new Password(password),
            DocumentFactory.create(documentNumber),
            UserType.CUSTOMER
        );
        when(userRepository.save(any(User.class))).thenReturn(savedUser);
        
        // Act
        User result = createUserUseCase.execute(name, email, password, documentNumber);
        
        // Assert
        assertNotNull(result);
        assertEquals(name, result.getName().getValue());
    }
}