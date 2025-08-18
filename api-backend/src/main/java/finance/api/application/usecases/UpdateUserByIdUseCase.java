package finance.api.application.usecases;

import finance.api.domain.entities.User;
import finance.api.adapters.dtos.CreateUserRequestDto;
import finance.api.domain.valueobjects.EntityId;

public class UpdateUserByIdUseCase{
    public User execute(EntityId userId, CreateUserRequestDto newUser){
        return null;
    }
}
