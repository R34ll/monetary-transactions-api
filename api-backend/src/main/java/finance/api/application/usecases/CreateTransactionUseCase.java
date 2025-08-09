package finance.api.application.usecases;


import finance.api.application.exceptions.AccountNotFoundException;
import finance.api.application.services.AccountHasBalanceService;
import finance.api.application.services.CheckIfAccountIsActiveService;
import finance.api.application.services.CheckIfSameAccountService;;
import finance.api.application.services.ValidTransferAmountService;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.repository.TransactionRepository;
import finance.api.domain.entities.Account;
import finance.api.domain.entities.Transaction;
import finance.api.domain.services.IdGenerator;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;
import finance.api.domain.valueobjects.Timestamp;

public class CreateTransactionUseCase{
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository; 
    private final IdGenerator idGenerator;

    public CreateTransactionUseCase(TransactionRepository transactionRepository, AccountRepository accountRepository, IdGenerator idGenerator){
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.idGenerator = idGenerator;
    }

    public Transaction execute(EntityId fromAccountId, EntityId toAccountId, Money transferAmount){
        // TODO: Handle null values

        // 1. Check if account exist
        Account fromAccount = accountRepository.findById(fromAccountId)
            .orElseThrow(() -> new AccountNotFoundException());

        Account toAccount = accountRepository.findById(toAccountId)
            .orElseThrow(() -> new AccountNotFoundException());


        // 2. Check if the accounts are the same
        CheckIfSameAccountService checkIfSameAccountService = new CheckIfSameAccountService();
        checkIfSameAccountService.check(fromAccount, toAccount);


        // 3. Create Transaction
        EntityId transactionId = idGenerator.generateId();
        Timestamp time = new Timestamp(System.currentTimeMillis());

        Transaction newTransaction = new Transaction(
            transactionId,
            fromAccountId,
            toAccountId,
            transferAmount,
            time,
            Transaction.Status.COMPLETED // TODO: Pending logic
        );

        return transactionRepository.save(newTransaction);

    }


}

