package org.holovin.minibank.app.port.in;

import org.holovin.minibank.shared.dto.response.account.AccountResponseDto;

public interface GetCurrentBalanceInPort {

    AccountResponseDto execute(Long accountId);
}
