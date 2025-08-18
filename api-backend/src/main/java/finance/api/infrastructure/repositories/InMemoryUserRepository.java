package finance.api.infrastructure.repositories;

import org.springframework.stereotype.Repository;

import finance.api.domain.entities.User;
import finance.api.domain.repository.UserRepository;
import finance.api.domain.valueobjects.Document;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.EntityId;

@Repository
public class InMemoryUserRepository implements UserRepository{
    @Override
    public User findByDocument(Document documentNumber) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findByEmail(Email email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public User findById(EntityId id) {
        // TODO Auto-generated method stub
        return null;
    }

    public User save(User user) {
        return null;
    };
}
