package finance.api.domain.repository;


import java.util.List;

import finance.api.domain.entities.User;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.Document;


public interface UserRepository {
    User findById(EntityId id);
    User findByEmail(Email email);
    User findByDocument(Document documentNumber);
    List<User> findAll();
    User save(User user);
    void deleteById(EntityId id);
    
}

