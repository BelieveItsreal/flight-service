package org.flightservice.service;

import java.util.List;

import org.flightservice.dto.UserRequestDTO;
import org.flightservice.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userDetail);

    UserResponseDTO getUserById(Long id);

    List<UserResponseDTO> getAllUser();
}
