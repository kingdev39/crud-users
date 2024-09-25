package com.kingdev.crud.controller;

import com.kingdev.crud.entity.User;
import com.kingdev.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> read(){
        return userService.read();
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public Optional<User> updateProduct(@PathVariable Long id, @RequestBody User updateUser) {
        return userService.update(id, updateUser);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
