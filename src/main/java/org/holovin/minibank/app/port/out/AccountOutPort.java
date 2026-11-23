package org.holovin.minibank.app.port.out;

import org.holovin.minibank.domain.model.Account;

import java.util.Optional;

public interface AccountOutPort {

    Optional<Account> findByNumberWithBalance(String number);
}
