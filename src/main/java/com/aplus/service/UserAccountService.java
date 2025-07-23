package com.aplus.service;

import com.aplus.entity.UserAccount;

public interface UserAccountService {
    UserAccount login(String loginName, String password);
    UserAccount register(String loginName, String password);
}
