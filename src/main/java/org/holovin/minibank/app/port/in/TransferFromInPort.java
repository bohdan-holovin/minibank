package org.holovin.minibank.app.port.in;

import org.holovin.minibank.shared.dto.request.account.AccountTransferRequestDto;
import org.holovin.minibank.shared.dto.response.transaction.TransactionResponseDto;

public interface TransferFromInPort {

    TransactionResponseDto execute(AccountTransferRequestDto request);
}
