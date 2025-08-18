package finance.api.application.usecases;

import finance.api.domain.repository.UserRepository;
import finance.api.domain.entities.User;
import finance.api.domain.valueobjects.EntityId;

public class FindUserByIdUseCase{
    UserRepository userRepository;

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