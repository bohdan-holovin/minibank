package org.holovin.minibank.infra.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.in.RegisterUserInPort;
import org.holovin.minibank.shared.dto.request.user.UserRegistrationRequestDto;
import org.holovin.minibank.shared.dto.response.user.UserResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final RegisterUserInPort registerUserInPort;

    @PostMapping("/users/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody @Valid UserRegistrationRequestDto request) {
        var userResponseDto = registerUserInPort.execute(request);
        return ResponseEntity.ok(userResponseDto);
    }
}
