package finance.api.adapters.dtos;

import finance.api.domain.entities.User;

public record UserResponseDto(String name, String email) {
	public static UserResponseDto from(User user) {
		return new UserResponseDto(
			user.getName() != null ? user.getName().getValue() : null,
			user.getEmail() != null ? user.getEmail().getValue() : null
		);
	}
}
