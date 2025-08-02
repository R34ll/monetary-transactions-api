package finance.api.domain.repository;

import finance.api.domain.entities.User;
import finance.api.domain.valueobjects.EntityId;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.Document;


public interface UserRepository {
    User findById(EntityId id);
    User findByEmail(Email email);
    User findByDocument(Document documentNumber);
    User save(User user);
    
}

