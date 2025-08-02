package finance.api.application.usecases;

import finance.api.domain.entities.User;
import finance.api.domain.repository.UserRepository;

public class CreateUserUseCase {
    private UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(User user) {

        userRepository.save(user);
    }
}
