package org.flightservice.controller;

import org.flightservice.dto.BookingRequestDTO;
import org.flightservice.dto.BookingResponseDTO;
import org.flightservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/bookings")
public class BookingController {
    
    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity<BookingResponseDTO>createBooking(@RequestBody BookingRequestDTO request) {
        BookingResponseDTO bookingDetail = bookingService.createBooking(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookingDetail);
    }
}
