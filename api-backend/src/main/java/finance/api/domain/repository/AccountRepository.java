package finance.api.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.User;
import finance.api.domain.valueobjects.EntityId;

public interface AccountRepository {
  Optional<Account> findById(EntityId id);
  Account save(Account account);
  Optional<Account> findByUserId(EntityId userId); // Search account by userId
  Optional<User> findUserById(EntityId accountId); // Search user Check if user exist

} 