package com.simplytodo.controller;

import com.simplytodo.entity.User;
import com.simplytodo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable  int id) {
        return userService.getUserById(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/users")
    @ResponseBody
    public User createOrUpdateUser(@RequestBody User user) {
        var res = userService.createOrUpdateUser(user);
        return res;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @GetMapping("/user/{title}")
    public List<User> getUserByNameAndPhone(@PathVariable String title) {
        return userService.getAllUserWithTaskTitle(title);
    }
}
