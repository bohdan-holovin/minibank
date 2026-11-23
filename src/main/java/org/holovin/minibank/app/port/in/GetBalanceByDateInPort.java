package org.holovin.minibank.app.port.in;

import org.holovin.minibank.shared.dto.response.account.AccountByDateResponseDto;

import java.time.LocalDate;

public interface GetBalanceByDateInPort {

    AccountByDateResponseDto execute(Long accountId, LocalDate date);
}
