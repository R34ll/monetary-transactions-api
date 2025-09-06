package finance.api.infrastructure.repositories;

import finance.api.domain.repository.TransactionRepository;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.entities.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryTransactionRepository implements TransactionRepository{
    private Map<EntityId, Transaction> storage = new HashMap<>();

    @Override
    public Optional<Transaction> findById(EntityId transactionId) {
        Transaction transaction = this.storage.get(transactionId);
        if(transaction != null) return Optional.of(transaction);
    
        return Optional.empty();
    }


    @Override
    public List<Transaction> findAllByAccountId(EntityId accountId) {
        List<Transaction> transactionsList = new ArrayList<>(); 

        for(Transaction transaction: storage.values()){
            if(transaction.getFromAccountId().equals(accountId)){ // TODO: Optimize
                transactionsList.add(transaction);
            }
        }

        return transactionsList;
    };

    @Override
    public Transaction save(Transaction transaction) {
        storage.put(transaction.getId(), transaction);
        return storage.get(transaction.getId());
    }



}
