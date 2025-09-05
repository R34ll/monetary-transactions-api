package finance.api.adapters.inbound.controllers.web.springboot;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import finance.api.adapters.dtos.CreateTransactionRequestDto;
import finance.api.adapters.dtos.TransactionResponseDto;
import finance.api.application.usecases.CreateTransactionUseCase;
import finance.api.application.usecases.FindTransactionByIdUseCase;
import finance.api.application.usecases.FindAllAccountTransactionsUseCase;

import finance.api.application.usecases.TransferMoneyToAccountUseCase;
import finance.api.domain.entities.Transaction;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;



import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/transactions")
public class TransactionController {
    // 1. Create new Transaction
    // 2. List all Transactions
    // 3. Return a transaction by id
    
    // private final CreateTransactionUseCase createTransactionUseCase;
    private final TransferMoneyToAccountUseCase transferMoneyToAccountUseCase;
    private final FindTransactionByIdUseCase findTransactionByIdUseCase;
    private final FindAllAccountTransactionsUseCase findAllAccountTransactionsUseCase;


    @Autowired
    public TransactionController(TransferMoneyToAccountUseCase transferMoneyToAccountUseCase, FindTransactionByIdUseCase findTransactionByIdUseCase, FindAllAccountTransactionsUseCase findAllAccountTransactionsUseCase){
        this.transferMoneyToAccountUseCase = transferMoneyToAccountUseCase;
        this.findTransactionByIdUseCase = findTransactionByIdUseCase;
        this.findAllAccountTransactionsUseCase = findAllAccountTransactionsUseCase;
    }


    @PostMapping
    public ResponseEntity<TransactionResponseDto> newTransaction(@RequestBody CreateTransactionRequestDto request){        
        Transaction newTransaction = transferMoneyToAccountUseCase.execute(
                new EntityId(request.fromAccount()),
                new EntityId(request.toAccount()),
                new Money(new BigDecimal(request.balance()))
            );

        return ResponseEntity.ok(TransactionResponseDto.from(newTransaction));
    }

    @GetMapping
    public ResponseEntity<TransactionResponseDto> getTransactionById(@PathVariable("id") String id){
        Transaction transaction = findTransactionByIdUseCase.execute(new EntityId(id));
        if(transaction == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(TransactionResponseDto.from(transaction));
    }
    
    @GetMapping
    public ResponseEntity<List<TransactionResponseDto>> getAllAccountTransactions(@RequestBody String accountId){
        List<Transaction> transactionList = findAllAccountTransactionsUseCase.execute(new EntityId(accountId));
        if(transactionList.size() == 0) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        
        Stream<Transaction> transactionStream = transactionList.stream();

        List<TransactionResponseDto> transactionResponseList = transactionStream
            .map(transaction -> TransactionResponseDto.from(transaction))
            .collect(Collectors.toList());


        return ResponseEntity.ok(transactionResponseList);
    }



}
