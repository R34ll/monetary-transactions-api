import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Money;

public class Account{
    public enum Status {
        ACTIVE,
        FROZEN,
        BLOCKED
    }
 

    private final EntityId id;
    private final EntityId userId;
    private final Money balance;
    private Status status;


    public Account(EntityId id, EntityId userId, Money balance, Status status) {
        if (id == null || userId == null || balance == null || status == null) {
            throw new IllegalArgumentException("Account parameters cannot be null");
        }
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.status = status;
    }

}

