package finance.api.application.usecases;

import finance.api.domain.entities.Account.Status;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.User;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.services.IdGenerator;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;
import finance.api.application.exceptions.UserNotFoundException;

import java.math.BigDecimal;

import finance.api.application.exceptions.AccountAlreadyExistsException;

public class CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final IdGenerator idGenerator;

    public CreateAccountUseCase(AccountRepository accountRepository, IdGenerator idGenerator) {
        this.accountRepository = accountRepository;
        this.idGenerator = idGenerator;
    }

    public Account execute(EntityId userId) {
        // 1. Verify if user exists. 
        accountRepository.findUserById(userId)
            .orElseThrow(() -> new UserNotFoundException());

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
