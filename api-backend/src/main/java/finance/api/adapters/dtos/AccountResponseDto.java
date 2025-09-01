package finance.api.adapters.dtos;

import finance.api.domain.entities.Account;

public record AccountResponseDto(String accountId) {
    public static AccountResponseDto from(Account account) {
		return new AccountResponseDto(
			account.getId() != null ? account.getId().getValue() : null
		);
	}
}
