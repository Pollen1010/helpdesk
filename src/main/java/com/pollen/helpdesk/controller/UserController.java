package com.pollen.helpdesk.controller;

import com.pollen.helpdesk.entity.User;
import com.pollen.helpdesk.service.UserService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import  java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private  final UserService userService;

    //Constructor Injection
    public  UserController (UserService userService){
        this.userService =userService;

    }
    //creating User Endpoint - Post /api/users
    @PostMapping
    public User createUser(@RequestBody User user) {//RequestBody - Take JSON from the request and convert it into a User object.
        return userService.createUser(user);
    }

    @GetMapping
    public  List<User>getAllUsers(){
        return  userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public  User getUserById(@PathVariable Long id){
        return  userService.getUserById(id);

}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
