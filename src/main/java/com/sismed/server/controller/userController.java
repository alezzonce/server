package com.sismed.server.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.sismed.server.entities.UserEntity;
import com.sismed.server.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class userController {
    @Autowired private UserService userService;
    
    @GetMapping("/all")
    public ResponseEntity<Pagination<UserEntity>> getAllUsers(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue = "5") int size){
        return new ResponseEntity<Pagination<UserEntity>>(userService.getAllUsers(page, size));
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        return new ResponseEntity<UserEntity>(userService.createUser(userEntity));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable UUID id @RequestBody UserEntity userEntity){
        return new ResponseEntity<UserEntity>(userService.updateUser(id, userEntity));
    }

    public void deleteUser(@PathVariable UUID id){
        userService.deleteUser(id);
    }
}
