package com.aplus.controller;

import com.aplus.entity.UserAccount;
import com.aplus.service.UserAccountService;
import com.aplus.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/account")
public class UserAccountController {

    @Autowired
    private UserAccountRepository userAccountRepository;
    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String loginName = body.get("login_name");
        String password = body.get("password");
        UserAccount account = userAccountService.login(loginName, password);
        if (account == null) {
            return ResponseEntity.status(404).body("user not found");
        }
        return ResponseEntity.ok(Map.of(
                "userId", account.getUserId(),
                "login_name", account.getLoginName()
        ));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> body) {
        String loginName = body.get("login_name");
        String password = body.get("password");
        UserAccount account = userAccountService.register(loginName, password);
        if (account == null) {
            return ResponseEntity.status(409).body("login_name exists");
        }
        return ResponseEntity.ok(Map.of(
                "userId", account.getUserId(),
                "login_name", account.getLoginName()
        ));
    }
    @GetMapping("/useraccount/{userId}")
    public Optional<UserAccount> findByLoginName(@PathVariable String userId) {
        return userAccountRepository.findByUserId(userId)
                .stream()
                .findFirst();
    }
}
