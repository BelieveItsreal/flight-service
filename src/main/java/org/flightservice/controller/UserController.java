package org.flightservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.flightservice.dto.UserRequestDTO;
import org.flightservice.dto.UserResponseDTO;
import org.flightservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userDetail) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDetail));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDTO>getById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>>getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
    
}
