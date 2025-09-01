package application.usecases;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import finance.api.application.usecases.CreateAccountUseCase;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.Account.Status;
import finance.api.domain.entities.User;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.services.IdGenerator;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;
import finance.api.domain.entities.User.UserType;
import finance.api.domain.valueobjects.Name;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.Password;
import finance.api.domain.valueobjects.DocumentFactory;
import finance.api.application.exceptions.AccountAlreadyExistsException;
import finance.api.application.exceptions.UserNotFoundException;



class CreateAccountUseCaseTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private IdGenerator idGenerator;

    private CreateAccountUseCase createAccountUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createAccountUseCase = new CreateAccountUseCase(accountRepository, idGenerator);
    }

    @Test
    @DisplayName("Should create account successfully")
    void shouldCreateAccountSuccessfully() {
        EntityId userId = new EntityId("user123");
        Money initialBalance = new Money(BigDecimal.ZERO);
        // Status status = Status.ACTIVE;

        User mockUser = new User(
            userId,
            new Name("John Doe"),
            new Email("john@doe.com"),
            new Password("P@ssword123"),
            DocumentFactory.create("12345678901"),
            UserType.CUSTOMER
        );

        when(idGenerator.generateId()).thenReturn(new EntityId("account123"));
        when(accountRepository.findUserById(userId)).thenReturn(Optional.of(mockUser));
        when(accountRepository.findByUserId(userId)).thenReturn(Optional.empty());
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Account createdAccount = createAccountUseCase.execute(userId);

        assertNotNull(createdAccount);
        assertEquals("account123", createdAccount.getId().getValue());
        assertEquals(userId, createdAccount.getUserId());
        assertEquals(initialBalance, createdAccount.getBalance());
        verify(accountRepository).save(any(Account.class));
    }

    @Test
    @DisplayName("Should throw exception when user not found")
    void shouldThrowExceptionWhenUserNotFound() {
        EntityId userId = new EntityId("user123");
        // Money initialBalance = new Money(BigDecimal.valueOf(1000));
        // Status status = Status.ACTIVE;

        when(accountRepository.findUserById(userId)).thenReturn(Optional.empty());

        UserNotFoundException exception = assertThrows(UserNotFoundException.class, () -> {
            createAccountUseCase.execute(userId);
        });

        assertEquals("No user exists with the provided ID", exception.getMessage());
    }

    @Test
    @DisplayName("Should throw exception when account already exists")
    void shouldThrowExceptionWhenAccountAlreadyExists() {
        EntityId userId = new EntityId("user123");
        // Money initialBalance = new Money(BigDecimal.valueOf(1000));
        // Status status = Status.ACTIVE;

        User mockUser = new User(
            userId,
            new Name("John Doe"),
            new Email("john@doe.com"),
            new Password("P@ssword123"),
            DocumentFactory.create("12345678901"),
            UserType.CUSTOMER
        );

        Account existingAccount = new Account(
            new EntityId("existingAccountId"),
            userId,
            new Money(BigDecimal.valueOf(500)),
            Status.ACTIVE
        );

        when(accountRepository.findUserById(userId)).thenReturn(Optional.of(mockUser));
        when(accountRepository.findByUserId(userId)).thenReturn(Optional.of(existingAccount));

        AccountAlreadyExistsException exception = assertThrows(AccountAlreadyExistsException.class, () -> {
            createAccountUseCase.execute(userId);
        });

        assertEquals("Account already exists for user with provided id", exception.getMessage());
    }
}
