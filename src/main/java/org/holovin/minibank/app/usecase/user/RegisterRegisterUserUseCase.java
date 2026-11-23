package org.holovin.minibank.app.usecase.user;

import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.in.RegisterUserInPort;
import org.holovin.minibank.app.service.UserService;
import org.holovin.minibank.domain.model.User;
import org.holovin.minibank.shared.dto.request.user.UserRegistrationRequestDto;
import org.holovin.minibank.shared.dto.response.user.UserResponseDto;
import org.holovin.minibank.shared.mapper.UserMapper;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegisterRegisterUserUseCase implements RegisterUserInPort {

    private final UserService userService;

    @Transactional
    @Retryable(
            retryFor = {CannotAcquireLockException.class},
            maxAttempts = 2,
            backoff = @Backoff(delay = 100)
    )
    public UserResponseDto execute(UserRegistrationRequestDto request) {
        var user = User.create(request.getUsername(), request.getAccountCount());
        userService.save(user);

        return UserMapper.toUserResponseDto(user);
    }
}
