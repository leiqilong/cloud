package com.hlife.account.feign.service.fallback;

import com.hlife.account.feign.service.BalanceService;
import com.hlife.common.entity.Balance;
import org.springframework.stereotype.Component;

@Component
public class BalanceServiceFallback implements BalanceService {
    @Override
    public Balance getBalance(Integer id) {
        return new Balance(0, 0, 0, "降级");
    }
}
