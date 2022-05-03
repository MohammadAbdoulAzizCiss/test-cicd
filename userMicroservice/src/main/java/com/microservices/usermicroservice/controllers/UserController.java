package com.microservices.usermicroservice.controllers;

import com.microservices.usermicroservice.DTO.ResponseTemplate;
import com.microservices.usermicroservice.entity.User;
import com.microservices.usermicroservice.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("/{id}")
    public ResponseTemplate getUserWithDepartment(@PathVariable("id") Long id){
        log.info("inside UserController-- getUserWithDepartment");
        return userService.getUserWithDepartment(id);
    }


    @PostMapping("/")
    public User saveUser(@RequestBody User user){

        log.info("inside UserController-- saveUser");
        return userService.saveUser(user);
    }
}
