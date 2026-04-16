package org.flightservice.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.flightservice.dto.UserRequestDTO;
import org.flightservice.dto.UserResponseDTO;
import org.flightservice.entity.Booking;
import org.flightservice.entity.User;
import org.flightservice.enums.BookingStatus;
import org.flightservice.enums.Role;
import org.flightservice.exception.ActiveBookingsExistException;
import org.flightservice.exception.UserNotFoundException;
import org.flightservice.mapper.UserMapper;
import org.flightservice.repository.BookingRepository;
import org.flightservice.repository.UserRepository;
import org.flightservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{


    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired 
    private PasswordEncoder passwordEncoder;


    @Override
    public UserResponseDTO createUser(UserRequestDTO userDetail) {
        User user = new User();
        user.setName(userDetail.getName());
        user.setEmail(userDetail.getEmail());
        user.setPassword(passwordEncoder.encode(userDetail.getPassword()));
        user.setRole(Role.USER);
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

    @Override
    @Transactional
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(()
        -> new UserNotFoundException("User not found with id: "+id));

        List<Booking> activeBookings = bookingRepository.findByUserIdAndStatus(id, BookingStatus.CONFIRMED);
        List<Booking> upcomingBookings = activeBookings.stream()
            .filter(b -> b.getFlight().getDepartureTime().isAfter(LocalDateTime.now()))
            .toList();
        if (!upcomingBookings.isEmpty()) {
            throw new ActiveBookingsExistException("Cannot delte account. You have " + upcomingBookings.size() + 
            " active booking(s) with upcoming flights. Please cancel them first");
        } 
        bookingRepository.deleteByUserId(id);
        userRepository.delete(user);
    }   
}
