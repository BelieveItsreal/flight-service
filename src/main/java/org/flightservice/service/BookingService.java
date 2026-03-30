package org.flightservice.service;

import org.flightservice.dto.BookingRequestDTO;
import org.flightservice.dto.BookingResponseDTO;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO request);
}
