package org.holovin.minibank.shared.mapper;

import org.holovin.minibank.domain.model.User;
import org.holovin.minibank.shared.dto.response.user.UserResponseDto;

import java.util.List;
import java.util.Optional;

public final class UserMapper {

    public static UserResponseDto toUserResponseDto(User user) {
        var dto = new UserResponseDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setCreatedDate(user.getCreatedDate());
        dto.setModifiedDate(user.getModifiedDate());

        dto.setAccounts(
                Optional.ofNullable(user.getAccounts())
                        .stream()
                        .flatMap(List::stream)
                        .map(AccountMapper::toAccountResponseDto)
                        .toList()
        );

        return dto;
    }
}
