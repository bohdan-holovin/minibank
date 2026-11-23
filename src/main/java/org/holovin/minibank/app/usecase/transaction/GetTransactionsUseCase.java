package org.holovin.minibank.app.usecase.transaction;

import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.in.GetTransactionsInPort;
import org.holovin.minibank.app.service.TransactionService;
import org.holovin.minibank.shared.dto.response.transaction.TransactionResponseDto;
import org.holovin.minibank.shared.mapper.TransactionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetTransactionsUseCase implements GetTransactionsInPort {

    private final TransactionService transactionService;

    @Transactional(readOnly = true)
    public List<TransactionResponseDto> execute(Long accountId, Integer limit, Integer offset) {
        var transactions = transactionService.findAllByAccountIdWithLimitAndOffset(accountId, limit, offset);

        return transactions.stream()
                .map(TransactionMapper::toTransactionDto)
                .toList();
    }
}
