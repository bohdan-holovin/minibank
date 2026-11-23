package org.holovin.minibank.app.service;

import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.out.UserOutPort;
import org.holovin.minibank.domain.model.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserOutPort userOutPort;

    public void save(User user) {
        userOutPort.save(user);
    }

    public boolean existsByUsername(String username) {
        return userOutPort.existsByUsername(username);
    }
}
