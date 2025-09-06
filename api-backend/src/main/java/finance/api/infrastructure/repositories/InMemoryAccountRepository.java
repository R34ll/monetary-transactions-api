package finance.api.infrastructure.repositories;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.User;
import finance.api.domain.repository.AccountRepository;
import finance.api.domain.valueobjects.EntityId;
import java.util.HashMap;

@Repository
public class InMemoryAccountRepository implements AccountRepository{
    private Map<EntityId, Account> storage = new HashMap<>();

    
    @Override
    public Account save(Account account) {
        storage.put(account.getId(), account);
        return storage.get(account.getId());
    }

    @Override
    public Optional<Account> findById(EntityId accountId) { // TODO: Handle Optional return
        // Account account = storage.get(accountId);
        // return account;

        for(Account account: storage.values()){
            if(account.getId().equals(accountId)){ // TODO: Use stream
                return Optional.of(account);
            }
        }

        return null;
    }

    @Override
    public Optional<Account> findByUserId(EntityId userId) {
        for(Account account: storage.values()){
            if(account.getUserId().equals(userId)){
                return Optional.of(account);
            }
        }
        return null;
    }

    @Override
    public Optional<User> findUserById(EntityId accountId) {
        // for(Account account: storage.values()){
        //     if(account.getId().equals(accountId)){
        //         User user = account.getUserId();

        //         return Optional.of(account.getUserId());
        //     }
        // }c
        return null;
    }

}


