package finance.api.application.usecases;

import finance.api.domain.repository.AccountRepository;
import finance.api.domain.repository.UserRepository;
import finance.api.domain.valueobjects.EntityId;

public class TransferMoneyToAccount {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public TransferMoneyToAccount(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public void execute(EntityId userId, EntityId accountId, double amount) {
    }


}
