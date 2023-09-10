package com.sismed.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.UUID;

import com.sismed.server.entities.UserEntity;
import com.sismed.server.services.UserService;
import com.sismed.server.utils.Pagination;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class MedicineTypeController {
    @Autowired private UserService userService;
    
    @GetMapping("/all")
    public ResponseEntity<Pagination<UserEntity>> getAllUsers(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue = "5") int size){
        return new ResponseEntity<Pagination<UserEntity>>(userService.getAllUsers(page, size), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity userEntity){
        return new ResponseEntity<UserEntity>(userService.createUser(userEntity), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserEntity> updateUser(@PathVariable UUID id, @RequestBody UserEntity userEntity){
        return new ResponseEntity<UserEntity>(userService.updateUser(id, userEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable UUID id){
        return new ResponseEntity<UserEntity>(userService.deleteById(id), HttpStatus.OK);
    }

}
