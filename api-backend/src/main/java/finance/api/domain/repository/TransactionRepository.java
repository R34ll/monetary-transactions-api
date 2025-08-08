package finance.api.domain.repository;


import java.util.Optional;
import finance.api.domain.entities.Transaction;
import finance.api.domain.valueobjects.EntityId;

public interface TransactionRepository{


    Transaction save(Transaction transaction);
    Optional<Transaction> findById(EntityId transactionId);


}