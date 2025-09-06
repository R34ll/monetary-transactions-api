package finance.api.application.usecases;

import finance.api.domain.entities.Account.Status;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.User;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.repository.UserRepository;
import finance.api.domain.services.IdGenerator;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;
import finance.api.application.exceptions.UserNotFoundException;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finance.api.application.exceptions.AccountAlreadyExistsException;


@Service
public class CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final IdGenerator idGenerator;

    @Autowired
    public CreateAccountUseCase(AccountRepository accountRepository, UserRepository userRepository,  IdGenerator idGenerator) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
        this.idGenerator = idGenerator;
    }

    public Account execute(EntityId userId) {
        // 1. Verify if user exists. 
        // accountRepository.findUserById(userId)
        //     .orElseThrow(() -> new UserNotFoundException());

        FindUserByIdUseCase findUserByIdUseCase = new FindUserByIdUseCase(userRepository);
        if(findUserByIdUseCase.execute(userId) == null){
            throw new UserNotFoundException();
        }

        // 2. Verify if account already exists
        if (accountRepository.findByUserId(userId).isPresent()) {
            throw new AccountAlreadyExistsException();
        }

        // 3. Create and save account
        EntityId accountId = idGenerator.generateId();
        Account account = new Account(
            accountId, 
            userId, 
            new Money(BigDecimal.ZERO), 
            Account.Status.ACTIVE
        );
        return accountRepository.save(account);
    }
}
