package finance.api.application.usecases;

import finance.api.domain.entities.Account.Status;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.User;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.services.IdGenerator;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;

public class CreateAccountUseCase {
    private AccountRepository accountRepository;
    private final IdGenerator idGenerator;


    public CreateAccountUseCase(AccountRepository accountRepository, IdGenerator idGenerator) {
        this.accountRepository = accountRepository;
        this.idGenerator = idGenerator;
    }

    public Account execute(EntityId userId, Money initialBalance, Status status) {
        // 1. Verify if user exists
        accountRepository.findUserById(userId).orElseThrow(() ->
            new IllegalArgumentException("User not found with id: " + userId.getValue())
        );

        // 2. Verify if account already exists
        accountRepository.findByUserId(userId).ifPresent(account -> {
            throw new IllegalArgumentException("Account already exists for user with id: " + userId.getValue());
        });

        // 3. Create and save account
        EntityId accountId = idGenerator.generateId();

        Account account = new Account(accountId, userId, initialBalance, status);

        return accountRepository.save(account);
    }

}
