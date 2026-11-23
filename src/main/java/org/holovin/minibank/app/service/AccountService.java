package org.holovin.minibank.app.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.holovin.minibank.app.port.out.AccountOutPort;
import org.holovin.minibank.domain.model.Account;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountOutPort accountOutPort;

    public Account findByNumberWithBalance(String number) {
        return accountOutPort.findByNumberWithBalance(number)
                .orElseThrow(() -> new EntityNotFoundException("Account with  number " + number));
    }
}
