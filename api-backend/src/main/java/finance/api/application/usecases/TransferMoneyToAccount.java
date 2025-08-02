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
        // TODO: Implement the logic to transfer money from user to account
        // 1. Find the user by userId
        // 2. Find the account by accountId
        // 3. Validate the transfer amount
        // 4. Update the user's balance
        // 5. Update the account's balance
        // 6. Save the updated user and account entities
        // 7. Handle any exceptions or errors that may occur during the process
    }


}
