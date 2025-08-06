package finance.api.domain.repository;

import java.util.Optional;

import finance.api.domain.entities.Account;
import finance.api.domain.entities.User;
import finance.api.domain.valueobjects.EntityId;

public interface AccountRepository {
  Account findById(EntityId id);
  Account save(Account account);
  Optional<Account> findByUserId(EntityId userId); // Search account by userId
  Optional<User> findUserById(EntityId userId); // Search user Check if user exist

} 