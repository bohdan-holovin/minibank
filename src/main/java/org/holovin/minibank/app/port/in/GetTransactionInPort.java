package org.holovin.minibank.app.port.in;

import org.holovin.minibank.shared.dto.response.transaction.TransactionResponseDto;

public interface GetTransactionInPort {

    TransactionResponseDto execute(Long transactionId);
}
