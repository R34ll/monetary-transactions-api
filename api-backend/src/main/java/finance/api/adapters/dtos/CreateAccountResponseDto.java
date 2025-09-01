package finance.api.adapters.dtos;

import finance.api.domain.entities.Account;

public record CreateAccountResponseDto(String accountId) {
    public static CreateAccountResponseDto from(Account account){
        return new CreateAccountResponseDto(
			account.getId() != null ? account.getId().getValue() : null
        );
    }
}
