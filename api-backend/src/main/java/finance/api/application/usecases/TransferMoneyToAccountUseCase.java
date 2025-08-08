package finance.api.application.usecases;

import java.util.Optional;

import finance.api.application.services.AccountHasBalanceService;
import finance.api.application.services.CheckIfAccountIsActiveService;
import finance.api.application.services.CheckIfSameAccountService;
import finance.api.application.services.ValidTransferAmountService;
import finance.api.domain.entities.Account;
import finance.api.domain.entities.Transaction;
import finance.api.domain.entities.User;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.repository.TransactionRepository;
import finance.api.domain.repository.UserRepository;
import finance.api.domain.services.IdGenerator;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;
import finance.api.domain.valueobjects.Timestamp;

public class TransferMoneyToAccountUseCase {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final IdGenerator idGenerator;

    public TransferMoneyToAccountUseCase(TransactionRepository transactionRepository, AccountRepository accountRepository, IdGenerator idGenerator) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.idGenerator = idGenerator;
    }

    public Transaction execute(EntityId fromAccountId, EntityId toAccountId, Money transferAmount) {
        // 1. Find the account by accountId
        Account fromAccount = accountRepository.findById(fromAccountId)
            .orElseThrow(() -> new IllegalArgumentException("Account not found"));

        Account toAccount = accountRepository.findById(toAccountId)
            .orElseThrow(() -> new IllegalArgumentException("Account do not found"));

        // 2. Account verification
        // Check if are same account
        CheckIfSameAccountService checkIfSameAccountService = new CheckIfSameAccountService();
        checkIfSameAccountService.check(fromAccount, toAccount);

        // check if they are active
        CheckIfAccountIsActiveService checkIfAccountIsActiveService = new CheckIfAccountIsActiveService();
        checkIfAccountIsActiveService.check(toAccount);
        checkIfAccountIsActiveService.check(fromAccount);


        // 3. Validate the transfer amount
        // Value can't be less than zero // # TODO: use service
        ValidTransferAmountService validTransferAmountService = new ValidTransferAmountService();
        validTransferAmountService.valid(transferAmount); // Transfer amount > 0

        // An account can't transfer what it doens't have
        AccountHasBalanceService accountHasBalanceService = new AccountHasBalanceService();
        accountHasBalanceService.check(fromAccount, transferAmount); // (Account balance - Transfer amount) > 0

        // 4. Update the account's balance
        fromAccount.debit(transferAmount);
        toAccount.credit(transferAmount);


        // 5. Create Transaction
        EntityId transactionId = idGenerator.generateId();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        Transaction newTransaction = new Transaction(
            transactionId,    
            fromAccountId,
            toAccountId,
            transferAmount,
            time,
            Transaction.Status.COMPLETED
        );

        // 6. Save the updated account entities
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        

        return transactionRepository.save(newTransaction);
    }


}
