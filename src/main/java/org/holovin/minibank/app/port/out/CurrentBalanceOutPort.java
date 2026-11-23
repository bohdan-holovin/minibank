package org.holovin.minibank.app.port.out;

import org.holovin.minibank.domain.model.CurrentBalance;

import java.util.Optional;

public interface CurrentBalanceOutPort {

    Optional<CurrentBalance> findByAccountId(Long accountId);
}
