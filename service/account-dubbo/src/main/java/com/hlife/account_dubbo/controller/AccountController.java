package com.hlife.account_dubbo.controller;

import com.hlife.common.entity.User;
import com.hlife.common_service.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    @Reference
    private BalanceService balanceService;

    private static Map<Integer, User> userMap = new HashMap() {{
        put(1, new User(1, "张三"));
        put(2, new User(2, "李四"));
        put(3, new User(3, "王五"));
    }};

    @RequestMapping("/acc/user")
    public User getUser(@RequestParam Integer id) {
        if(id != null && userMap.containsKey(id)) {
            return userMap.get(id).setBalance(this.balanceService.getBalance(id));
        }
        return new User(0, "");
    }
}
