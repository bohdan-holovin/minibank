package org.holovin.minibank.app.port.in;

import org.holovin.minibank.shared.dto.response.transaction.TransactionResponseDto;

import java.util.List;

public interface GetTransactionsInPort {

    List<TransactionResponseDto> execute(Long accountId, Integer limit, Integer offset);
}
