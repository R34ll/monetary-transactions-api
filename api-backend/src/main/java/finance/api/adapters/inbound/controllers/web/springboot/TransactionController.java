package finance.api.adapters.inbound.controllers.web.springboot;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finance.api.application.usecases.CreateTransactionUseCase;
import finance.api.application.usecases.TransferMoneyToAccountUseCase;
import finance.api.domain.entities.Transaction;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/transactions")
public class TransactionController {
    // 1. Create new Transaction
    // 2. List all Transactions
    // 3. Return a transaction by id
    
    // private final CreateTransactionUseCase createTransactionUseCase;
    private final TransferMoneyToAccountUseCase transferTMoneyToAccountUseCase;
    private final FindTransactionByIdUseCase findTransactionByIdUseCase;
    private final GetAllAccountTransactionsUseCase getAllAccountTransactionsUseCase;


    @PostMapping
    public ResponseEntity<TransactionResponseDto> newTransaction(@RequestBody CreateTransactionRequestDto request){        
        Transaction newTransaction = transferMoneyToAccountUseCase.execute(
                new EntityId(request.fromAccount),
                new EntityId(request.toAccount),
                new Money(request.amount)
            );

        return ResponseEntity.ok(TransactionResponseDto.from(newTransaction));
    }

    @GetMapping
    public ResponseEntity<TransactionResponseDto> getTransactionById(@PathVariable("id") String id){
        Transaction transaction = findTransactionByIdUseCase.execute(new EntityId(id));
        if(transaction == null) return ResponseEntity.status(httpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(TransactionResponseDto.from(transaction));
    }
    
    @GetMapping
    public ResponseEntity<List<TransactionResponseDto>> getAllAccountTransactions(@RequestBody String accountId){
        List<Transaction> transactionList = getAllAccountTransactionsUseCase.execute(new EntityId(accountId));
        if(transactionList.size() == 0) return ResponseEntity.status(httpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(transactionList);
    }



}
