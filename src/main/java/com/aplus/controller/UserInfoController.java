package com.aplus.controller;

import com.aplus.entity.UserInfo;
import com.aplus.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class UserInfoController {
    @Autowired
    private UserInfoRepository userRepository;

    @GetMapping("/userinfo")
    public List<UserInfo> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/userinfo/{userId}")
    public Optional<UserInfo> getById(@PathVariable String userId) {
        return userRepository.findById(userId);
    }

    @PostMapping("/createUserinfo")
    public UserInfo create(@RequestBody UserInfo user) {
        // Generate server-managed fields
        //user.setUserId(UUID.randomUUID().toString().replace("-", "").substring(0, 15));
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());

        // Ensure default flags
        user.setIsActive(true);
        user.setIsDeleted(false);
        return userRepository.save(user);
    }

    @PutMapping("/updateUserinfo/{userId}")
    public UserInfo update(@PathVariable String userId, @RequestBody UserInfo user) {
        user.setUserId(userId);
        user.setUpdatedDate(new Date());
        return userRepository.save(user);
    }

    @DeleteMapping("/userinfo/{userId}")
    public void delete(@PathVariable String userId) {
        userRepository.deleteById(userId);
    }
}