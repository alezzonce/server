package com.sismed.server.controllers;

import java.util.UUID;

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

import com.sismed.server.entities.UserConditionEntity;
import com.sismed.server.services.UserConditionService;
import com.sismed.server.utils.Pagination;

@RestController
@RequestMapping("/userCondition")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class userConditionController {
    @Autowired private UserConditionService userConditionService;
    
    @GetMapping("/all")
    public ResponseEntity<Pagination<UserConditionEntity>> getAllUsers(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue = "5") int size){
        return new ResponseEntity<Pagination<UserConditionEntity>>(userConditionService.getAllUsers(page, size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserConditionEntity> createUser(@RequestBody UserConditionEntity UserConditionEntity){
        return new ResponseEntity<UserConditionEntity>(userConditionService.createUserCondition(UserConditionEntity), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserConditionEntity> updateUser(@PathVariable UUID id, @RequestBody UserConditionEntity UserConditionEntity){
        return new ResponseEntity<UserConditionEntity>(userConditionService.updateUserCondition(id, UserConditionEntity), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserConditionEntity> deleteUser(@PathVariable UUID id){
        return new ResponseEntity<UserConditionEntity>(userConditionService.deleteById(id), HttpStatus.OK);
    }


}
