package com.hlife.payment_dubbo.service.in_memory;

import com.hlife.common.entity.Balance;
import com.hlife.common_service.service.BalanceService;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//@Service(protocol = "dubbo")
@Service(interfaceClass = BalanceService.class, timeout = 15000, protocol = "dubbo")
@Component
public class InMemoryBalanceService implements BalanceService {

    final static Map<Integer, Balance> balanceMap = new HashMap() {{
        put(1, new Balance(1, 10, 1000));
        put(2, new Balance(2, 0, 10000));
        put(3, new Balance(3, 100, 0));
    }
    };

    @Override
    public Balance getBalance(Integer id) {
        if(id != null && balanceMap.containsKey(id)) {
            return balanceMap.get(id);
        }
        return new Balance(0, 0, 0, "不存在");
    }
}
