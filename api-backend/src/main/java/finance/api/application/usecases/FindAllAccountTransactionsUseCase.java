package finance.api.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import finance.api.domain.entities.Transaction;
import finance.api.domain.repository.TransactionRepository;
import finance.api.domain.valueobjects.EntityId;


@Service
public class FindAllAccountTransactionsUseCase{

    @Autowired
    private final TransactionRepository transactionRepository;

    public FindAllAccountTransactionsUseCase(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }


    public List<Transaction> execute(EntityId accountId){
        List<Transaction> transactionsList = transactionRepository.findAllByAccountId(accountId);

        return transactionsList;

    }
}
