package org.holovin.minibank.app.port.out;

import org.holovin.minibank.domain.model.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionOutPort {

    void save(Transaction transaction);

    Optional<Transaction> findById(Long id);

    Optional<Transaction> findByUuid(String uuid);

    List<Transaction> findAllPendingTransactionsWithLock(int limit);

    List<Transaction> findAllByAccountIdWithLimitAndOffset(Long accountId, int limit, int offset);
}
