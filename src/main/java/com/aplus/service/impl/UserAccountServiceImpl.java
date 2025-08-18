package com.aplus.service.impl;

import com.aplus.entity.UserAccount;
import com.aplus.repository.UserAccountRepository;
import com.aplus.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    @Transactional(readOnly = true)
    public UserAccount login(String loginName, String password) {
        Optional<UserAccount> opt = userAccountRepository.findByLoginName(loginName);
        if (opt.isPresent()) {
            UserAccount account = opt.get();
            // パスワードハッシュの比較はBCryptで行う
            if (account.getPasswordHash() != null && encoder.matches(password, account.getPasswordHash())) {
                return account;
            }
        }
        return null;
    }

    @Override
    @Transactional
    public UserAccount register(String loginName, String password, String nickName) {
        if (userAccountRepository.findByLoginName(loginName).isPresent()) {
            return null;
        }
        UserAccount account = new UserAccount();
        account.setUserId(UUID.randomUUID().toString().replace("-", "").substring(0, 15));
        account.setLoginName(loginName);
        account.setPasswordHash(encoder.encode(password));
        account.setNickName(nickName);
        account.setLoginStatus("active");
        account.setLoginFailCount(0);
        account.setIsDeleted(false);
        return userAccountRepository.save(account);
    }
}
