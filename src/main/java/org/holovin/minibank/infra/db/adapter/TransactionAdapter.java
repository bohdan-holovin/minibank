package org.holovin.minibank.infra.db.adapter;

import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.out.TransactionOutPort;
import org.holovin.minibank.domain.model.Transaction;
import org.holovin.minibank.infra.db.repository.TransactionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransactionAdapter implements TransactionOutPort {

    private final TransactionRepository transactionRepository;

    @Override
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @Override
    public Optional<Transaction> findByUuid(String uuid) {
        return transactionRepository.findByUuid(uuid);
    }

    @Override
    public List<Transaction> findAllPendingTransactionsWithLock(int limit) {
        return transactionRepository.findAllPendingTransactionsWithLock(limit);
    }

    @Override
    public List<Transaction> findAllByAccountIdWithLimitAndOffset(Long accountId, int limit, int offset) {
        return transactionRepository.findAllByAccountIdWithLimitAndOffset(accountId, limit, offset);
    }
}
