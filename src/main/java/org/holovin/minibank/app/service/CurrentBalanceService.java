package org.holovin.minibank.app.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.out.CurrentBalanceOutPort;
import org.holovin.minibank.domain.model.CurrentBalance;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentBalanceService {

    private final CurrentBalanceOutPort currentBalanceOutPort;

    public CurrentBalance findByAccountId(Long accountId) {
        return currentBalanceOutPort.findByAccountId(accountId)
                .orElseThrow(() -> new EntityNotFoundException("CurrentBalance not found: " + accountId));
    }
}
