package finance.api.infrastructure.repositories;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.String;
import org.springframework.stereotype.Repository;

import finance.api.domain.entities.User;
import finance.api.domain.repository.UserRepository;
import finance.api.domain.valueobjects.Document;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.EntityId;

@Repository
public class InMemoryUserRepository implements UserRepository{
    private Map<EntityId, User> storage = new HashMap<>();

    @Override
    public User findByDocument(Document documentNumber) {

        for(User user: storage.values()){
            if(user.getDocument().getValue().equals(documentNumber.getValue())){
                return user;
            }
        }

        return null;
    }

    @Override
    public User findByEmail(Email email) {
        for(User user: storage.values()){
            if(user.getEmail().getValue().equals(email.getValue())  ){ // TODO: Optimize to compare objects
                return user;
            }
        }
        return null;
    }

    @Override
    public User findById(EntityId id) {
        return storage.get(id);
    }

    public List<User> findAll(){ // #TODO: Return list
        return new ArrayList<>(storage.values());
    }


    public void deleteById(EntityId id){
        storage.remove(id);
    }

    @Override
    public User save(User user) {
        storage.put(user.getId(), user);
        return user;
    };
}
