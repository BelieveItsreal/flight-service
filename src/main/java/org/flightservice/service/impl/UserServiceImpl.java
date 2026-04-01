package org.flightservice.service.impl;

import java.util.List;

import org.flightservice.dto.UserRequestDTO;
import org.flightservice.dto.UserResponseDTO;
import org.flightservice.entity.User;
import org.flightservice.exception.UserNotFoundException;
import org.flightservice.mapper.UserMapper;
import org.flightservice.repository.UserRepository;
import org.flightservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{


    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;


    @Override
    public UserResponseDTO createUser(UserRequestDTO userDetail) {
        User user = new User();
        user.setName(userDetail.getName());
        user.setEmail(userDetail.getEmail());
        user.setPassword(userDetail.getPassword());
        user.setPassportNumber(userDetail.getPassportNumber());
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(() 
        -> new UserNotFoundException("User Not found with id: " +id)));
    }

    @Override
    public List<UserResponseDTO> getAllUser() {
        return userRepository.findAll().stream().map(userDetail -> userMapper.toDto(userDetail)).toList();
    }   
}
