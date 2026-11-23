package org.holovin.minibank.app.port.in;

import org.holovin.minibank.shared.dto.request.user.UserRegistrationRequestDto;
import org.holovin.minibank.shared.dto.response.user.UserResponseDto;

public interface RegisterUserInPort {

    UserResponseDto execute(UserRegistrationRequestDto request);
}
