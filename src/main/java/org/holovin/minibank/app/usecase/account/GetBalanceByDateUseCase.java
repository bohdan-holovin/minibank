package org.holovin.minibank.app.usecase.account;

import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.in.GetBalanceByDateInPort;
import org.holovin.minibank.app.service.DayBalanceService;
import org.holovin.minibank.shared.dto.response.account.AccountByDateResponseDto;
import org.holovin.minibank.shared.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class GetBalanceByDateUseCase implements GetBalanceByDateInPort {

    private final DayBalanceService dayBalanceService;

    @Transactional(readOnly = true)
    public AccountByDateResponseDto execute(Long accountId, LocalDate date) {
        var dayBalance = dayBalanceService.findByAccountIdAndBalanceDate(accountId, date);
        return AccountMapper.toAccountByDateResponseDto(dayBalance);
    }
}
