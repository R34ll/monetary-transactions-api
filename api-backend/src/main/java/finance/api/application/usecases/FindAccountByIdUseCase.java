package finance.api.application.usecases;

import finance.api.application.exceptions.AccountNotFoundException;
import finance.api.domain.entities.Account;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.valueobjects.EntityId;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FindAccountByIdUseCase {
    private final AccountRepository accountRepository;

    @Autowired
    public FindAccountByIdUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public Account execute(EntityId accountId){
        // 1. Validate input
        if (accountId == null) {
            throw new IllegalArgumentException("Account ID must not be null");
        }
        Account account = accountRepository.findById(accountId)
            .orElseThrow(() -> new AccountNotFoundException());

        return account;

    }
}