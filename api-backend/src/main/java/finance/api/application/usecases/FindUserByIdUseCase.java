package finance.api.application.usecases;

import finance.api.domain.repository.UserRepository;
import finance.api.domain.entities.User;
import finance.api.domain.valueobjects.EntityId;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class FindUserByIdUseCase{
    private UserRepository userRepository;

    @Autowired
    public FindUserByIdUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public User execute(EntityId id){
        if(id == null){
            throw new IllegalArgumentException("User ID cannot be null"); // TODO: Create custom exception
        }

        return userRepository.findById(id); 

    }   

}