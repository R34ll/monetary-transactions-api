package finance.api.application.usecases;

import finance.api.application.exceptions.UserNotFoundException;
import finance.api.domain.entities.User;
import finance.api.domain.repository.UserRepository;
import finance.api.domain.valueobjects.EntityId;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DeleteUserByIdUseCase{
    private UserRepository userRepository;

    @Autowired
    public DeleteUserByIdUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void execute(EntityId id){
        User user = userRepository.findById(id);
        if(user == null){
            throw new UserNotFoundException();
        }

        userRepository.deleteById(id);
    }
}