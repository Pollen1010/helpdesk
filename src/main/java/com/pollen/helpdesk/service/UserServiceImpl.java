package com.pollen.helpdesk.service;

import  com.pollen.helpdesk.entity.User;
import  com.pollen.helpdesk.repository.UserRepository;
import  org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import  java.util.List;

@Service
public  class UserServiceImpl implements  UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }
    @Override

    public  User createUser(User user){
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        user.setCreatedDate(LocalDateTime.now());
        return  userRepository.save(user);
    }
    @Override

    public List<User> getAllUsers(){
        return  userRepository.findAll();
    }
    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

