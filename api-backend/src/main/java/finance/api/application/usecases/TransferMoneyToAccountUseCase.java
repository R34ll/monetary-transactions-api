package finance.api.application.usecases;

import java.util.Optional;

import finance.api.application.exceptions.AccountNotFoundException;
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
            .orElseThrow(() -> new AccountNotFoundException());

        Account toAccount = accountRepository.findById(toAccountId)
            .orElseThrow(() -> new AccountNotFoundException());

            
        // 2. Check if they are active
        CheckIfAccountIsActiveService checkIfAccountIsActiveService = new CheckIfAccountIsActiveService();
        checkIfAccountIsActiveService.check(toAccount);
        checkIfAccountIsActiveService.check(fromAccount);
        
        // 3. Validate the transfer amount (amount > 0)
        // Value can't be less than zero 
        ValidTransferAmountService validTransferAmountService = new ValidTransferAmountService();
        validTransferAmountService.valid(transferAmount); // Transfer amount > 0

        // An account can't transfer what it doens't have
        AccountHasBalanceService accountHasBalanceService = new AccountHasBalanceService();
        accountHasBalanceService.check(fromAccount, transferAmount); // (Account balance - Transfer amount) > 0


        // 4. Update the account's balance
        fromAccount.debit(transferAmount);
        toAccount.credit(transferAmount);



        // 5. Save the updated account entities
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
        

        // 6. Create Transaction
        CreateTransactionUseCase createTransactionUseCase = new CreateTransactionUseCase(transactionRepository, accountRepository, idGenerator);

        return createTransactionUseCase.execute(fromAccountId, toAccountId, transferAmount);        

    }


}
