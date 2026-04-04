package org.flightservice.service;

import java.util.List;

import org.flightservice.dto.BookingRequestDTO;
import org.flightservice.dto.BookingResponseDTO;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO request);

    List<BookingResponseDTO> getAllBooking();

    BookingResponseDTO getBookingById(Long id);

    BookingResponseDTO cancelBooking(Long id);
}
