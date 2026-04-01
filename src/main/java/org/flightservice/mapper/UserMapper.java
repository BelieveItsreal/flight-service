package org.flightservice.mapper;

import org.flightservice.dto.UserResponseDTO;
import org.flightservice.entity.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public UserResponseDTO toDto(User user){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassportNumber(user.getPassportNumber());
        return dto;
    }
}
