package org.holovin.minibank.app.port.out;

import org.holovin.minibank.domain.model.User;

public interface UserOutPort {

    void save(User user);

    boolean existsByUsername(String username);
}
