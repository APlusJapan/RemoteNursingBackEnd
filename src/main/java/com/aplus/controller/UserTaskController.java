package com.aplus.controller;

import com.aplus.entity.UserTask;
import com.aplus.repository.UserTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserTaskController {
    @Autowired
    private UserTaskRepository userTaskRepository;

    @GetMapping("/usertask")
    public List<UserTask> getAll() {
        return userTaskRepository.findAll();
    }

    @GetMapping("/usertask/{id}")
    public Optional<UserTask> getById(@PathVariable Integer id) {
        return userTaskRepository.findById(id);
    }

    @PostMapping("/usertask")
    public UserTask create(@RequestBody UserTask userTask) {
        return userTaskRepository.save(userTask);
    }

    @PutMapping("/usertask/{id}")
    public UserTask update(@PathVariable Integer id, @RequestBody UserTask userTask) {
        userTask.setId(id);
        return userTaskRepository.save(userTask);
    }

    @DeleteMapping("/usertask/{id}")
    public void delete(@PathVariable Integer id) {
        userTaskRepository.deleteById(id);
    }

    @GetMapping(value = "/usertask", params = "userId")
    public List<UserTask> getByUserId(@RequestParam String userId) {
        return userTaskRepository.findByUserId(userId);
    }
}
