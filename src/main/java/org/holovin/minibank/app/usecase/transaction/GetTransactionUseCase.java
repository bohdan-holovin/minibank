package org.holovin.minibank.app.usecase.transaction;

import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.in.GetTransactionInPort;
import org.holovin.minibank.app.service.TransactionService;
import org.holovin.minibank.shared.dto.response.transaction.TransactionResponseDto;
import org.holovin.minibank.shared.mapper.TransactionMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetTransactionUseCase implements GetTransactionInPort {

    private final TransactionService transactionService;

    @Transactional(readOnly = true)
    public TransactionResponseDto execute(Long transactionId) {
        var transactions = transactionService.findById(transactionId);
        return TransactionMapper.toTransactionDto(transactions);
    }
}
