package finance.api.adapters.dtos;

import finance.api.domain.valueobjects.Name;
import finance.api.domain.valueobjects.Email;
import finance.api.domain.valueobjects.Password;
import finance.api.domain.valueobjects.Document;
import finance.api.domain.entities.User.UserType;



public record UpdateUserRequestDto(Name name, Email email, Password password, Document document, UserType userType){}

