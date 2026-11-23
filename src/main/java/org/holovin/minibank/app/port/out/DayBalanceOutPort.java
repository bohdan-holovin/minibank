package org.holovin.minibank.app.port.out;

import org.holovin.minibank.domain.model.DayBalance;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public interface DayBalanceOutPort {

    void createDailySnapshotsBulk(LocalDate balanceDate, LocalDateTime createdDate);

    boolean existsByBalanceDate(LocalDate balanceDate);

    Optional<DayBalance> findByAccountIdAndBalanceDate(Long accountId, LocalDate balanceDate);
}
