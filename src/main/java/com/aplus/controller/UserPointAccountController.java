package com.aplus.controller;

import com.aplus.entity.UserPointAccount;
import com.aplus.repository.UserPointAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/point/account")
public class UserPointAccountController {
    @Autowired
    private UserPointAccountRepository userPointAccountRepository;


    @GetMapping("/{userId}")
    public ResponseEntity<UserPointAccount> getByUserId(@PathVariable String userId) {
        return userPointAccountRepository.findById(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("")
    public UserPointAccount createOrUpdate(@RequestBody UserPointAccount account) {
        UserPointAccount existing = userPointAccountRepository.findById(account.getUserId()).orElse(null);
        if (existing != null) {
            // createTimeを保持
            account.setCreateTime(existing.getCreateTime());
            // updatedTimeを更新
            account.setUpdatedTime(new java.util.Date());
        } else {
            // 新規作成時
            account.setCreateTime(new java.util.Date());
            account.setUpdatedTime(new java.util.Date());
        }
        return userPointAccountRepository.save(account);
    }
}
