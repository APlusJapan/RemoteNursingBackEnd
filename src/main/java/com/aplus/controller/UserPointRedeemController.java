package com.aplus.controller;

import com.aplus.entity.UserPointRedeem;
import com.aplus.repository.UserPointRedeemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/point/redeem")
public class UserPointRedeemController {
    @Autowired
    private UserPointRedeemRepository userPointRedeemRepository;

    @GetMapping("/user/{userId}")
    public List<UserPointRedeem> getRedeemsByUserId(@PathVariable String userId) {
        return userPointRedeemRepository.findByUserIdOrderByCreateTimeDesc(userId);
    }

    @PostMapping("")
    public UserPointRedeem create(@RequestBody UserPointRedeem redeem) {
        UserPointRedeem existing = null;
        if (redeem.getRedeemId() != null) {
            existing = userPointRedeemRepository.findById(redeem.getRedeemId()).orElse(null);
        }
        if (existing != null) {
            redeem.setCreateTime(existing.getCreateTime());
            redeem.setUpdatedTime(new java.util.Date());
        } else {
            redeem.setCreateTime(new java.util.Date());
            redeem.setUpdatedTime(new java.util.Date());
        }
        return userPointRedeemRepository.save(redeem);
    }
}
