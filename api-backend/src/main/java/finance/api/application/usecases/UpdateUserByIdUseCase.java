package finance.api.application.usecases;

import finance.api.domain.entities.User;
import finance.api.domain.repository.UserRepository;
import finance.api.adapters.dtos.CreateUserRequestDto;
import finance.api.domain.valueobjects.EntityId;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UpdateUserByIdUseCase{
    private UserRepository userRepository;

    @Autowired
    public UpdateUserByIdUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User execute(EntityId userId, CreateUserRequestDto newUser){
        return null;
    }
}
