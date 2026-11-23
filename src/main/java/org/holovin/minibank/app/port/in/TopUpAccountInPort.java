package org.holovin.minibank.app.port.in;

import org.holovin.minibank.shared.dto.request.account.AccountTopUpRequestDto;
import org.holovin.minibank.shared.dto.response.transaction.TransactionResponseDto;

public interface TopUpAccountInPort {

    TransactionResponseDto execute(AccountTopUpRequestDto request);
}
