

public class FindUserByIdUseCase{
    UserRepository userRepository;

    public FindUserByIdUseCase(UserRepository userRepository){
        this.userRepository = userRepository;
    }



    public Optional<User> execute(EntityId id){
        if(id == null){
            throw new IllegalArgumentException("User ID cannot be null"); // TODO: Create custom exception
        }

        return userRepository.findById(id); 

    }   

}