package com.kingdev.crud.service;

import com.kingdev.crud.entity.User;
import com.kingdev.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> read(){
        return userRepository.findAll();
    }

    public User create(User user){
        return userRepository.save(user);
    }

    public Optional<User> update(Long id, User updateUser) {
        return userRepository.findById(id).map(user -> {
            user.setName(updateUser.getName());
            user.setEmail(updateUser.getEmail());
            user.setPassword(updateUser.getPassword());
            return userRepository.save(user);
        });
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

}
