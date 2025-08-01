package finance.api.domain.entities;

import java.security.Timestamp;

import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;

public class Transaction{
    public enum Status{
        PENDING, COMPLETED, FAILED
    };

    private final EntityId id;
    private final EntityId fromAccountId;
    private final EntityId toAccountId;
    private final Money amount;
    
    private final Timestamp timestamp;
    private final Status status;

    public Transaction(EntityId id, EntityId fromAccount, EntityId toAccount, Money amount, Timestamp timestamp, Status status) {
        if (id == null || fromAccount == null || toAccount == null || amount == null || timestamp == null || status == null) {
            throw new IllegalArgumentException("Transaction parameters cannot be null");
        }
        this.id = id;
        this.fromAccountId = fromAccount;
        this.toAccountId = toAccount;
        this.amount = amount;
        this.timestamp = timestamp;
        this.status = status;
    }

}