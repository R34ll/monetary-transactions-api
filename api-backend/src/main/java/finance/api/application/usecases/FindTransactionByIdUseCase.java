package finance.api.application.usecases;

import finance.api.application.exceptions.TransactionNotFoundException;
import finance.api.domain.entities.Transaction;
import finance.api.domain.repository.TransactionRepository;
import finance.api.domain.valueobjects.EntityId;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class FindTransactionByIdUseCase{

    @Autowired
    private final TransactionRepository transactionRepository;

    public FindTransactionByIdUseCase(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }


    public Transaction execute(EntityId id){
        
        Transaction transaction = transactionRepository.findById(id)
            .orElseThrow(() -> new TransactionNotFoundException()); 


        return transaction;

    }
}
