package org.flightservice.dto;

import java.time.LocalDateTime;

import org.flightservice.enums.BookingStatus;
import org.flightservice.enums.SeatClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponseDTO {
    private Long bookingId;
    private String flightNumber;
    private String sourceCity;
    private String destinationCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private SeatClass seatClass;
    private String passengerName;
    private String passengerEmail;
    private String passportNumber;
    private Double priceAtBooking;
    private LocalDateTime bookingTime;
    private BookingStatus status;
}
