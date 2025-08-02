package finance.api.application.usecases;

import finance.api.domain.entities.Account;
import finance.api.domain.repository.AccountRepository;

public class CreateAccountUseCase {
    private AccountRepository accountRepository;

    public CreateAccountUseCase(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void execute(Account account) {
        accountRepository.save(account);
    }   
}
