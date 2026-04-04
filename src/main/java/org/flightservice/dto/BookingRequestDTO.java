package org.flightservice.dto;

import org.flightservice.enums.SeatClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingRequestDTO {
    private Long flightId;
    private SeatClass seatClass;
    private Long userId;
    private String passportNumber;
}
