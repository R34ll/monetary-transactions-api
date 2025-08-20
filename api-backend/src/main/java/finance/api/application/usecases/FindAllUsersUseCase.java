package finance.api.application.usecases;

import java.util.List;

import finance.api.domain.entities.User;
import finance.api.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class FindAllUsersUseCase {
    private UserRepository userRepository;

    @Autowired
    public FindAllUsersUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    public List<User> execute(){
        return userRepository.findAll();

    }     
}