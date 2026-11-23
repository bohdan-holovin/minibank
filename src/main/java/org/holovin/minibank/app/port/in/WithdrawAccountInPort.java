package org.holovin.minibank.app.port.in;

import org.holovin.minibank.shared.dto.request.account.AccountWithdrawRequestDto;
import org.holovin.minibank.shared.dto.response.transaction.TransactionResponseDto;

public interface WithdrawAccountInPort {

    TransactionResponseDto execute(AccountWithdrawRequestDto request);
}
