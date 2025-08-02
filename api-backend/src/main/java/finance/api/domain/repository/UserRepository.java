package finance.api.domain.repository;

import finance.api.domain.entities.User;
import finance.api.domain.valueobjects.EntityId;

public interface UserRepository {
    User findById(EntityId id);
    void save(User user);
    
}

