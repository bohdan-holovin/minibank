package org.holovin.minibank.infra.db.adapter;

import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.out.AccountOutPort;
import org.holovin.minibank.domain.model.Account;
import org.holovin.minibank.infra.db.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountAdapter implements AccountOutPort {

    private final AccountRepository accountRepository;

    @Override
    public Optional<Account> findByNumberWithBalance(String number) {
        return accountRepository.findByNumberWithBalance(number);
    }
}
