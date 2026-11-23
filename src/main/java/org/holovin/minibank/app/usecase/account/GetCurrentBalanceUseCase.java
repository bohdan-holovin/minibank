package org.holovin.minibank.app.usecase.account;

import lombok.RequiredArgsConstructor;
import org.holovin.minibank.app.port.in.GetCurrentBalanceInPort;
import org.holovin.minibank.app.service.CurrentBalanceService;
import org.holovin.minibank.shared.dto.response.account.AccountResponseDto;
import org.holovin.minibank.shared.mapper.AccountMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GetCurrentBalanceUseCase implements GetCurrentBalanceInPort {

    private final CurrentBalanceService currentBalanceService;

    @Transactional(readOnly = true)
    public AccountResponseDto execute(Long accountId) {
        var currentBalance = currentBalanceService.findByAccountId(accountId);
        return AccountMapper.toAccountResponseDto(currentBalance);
    }
}
