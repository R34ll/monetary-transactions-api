package finance.api.domain.repository;

import finance.api.domain.entities.Account;
import finance.api.domain.valueobjects.EntityId;

public interface AccountRepository {
  Account findById(EntityId id);
  void save(Account account);
} 