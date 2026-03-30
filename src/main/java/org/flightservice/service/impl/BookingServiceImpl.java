package org.flightservice.service.impl;

import java.time.LocalDateTime;

import org.flightservice.dto.BookingRequestDTO;
import org.flightservice.dto.BookingResponseDTO;
import org.flightservice.entity.Booking;
import org.flightservice.entity.Flight;
import org.flightservice.entity.FlightSeat;
import org.flightservice.enums.BookingStatus;
import org.flightservice.exception.FlightNotFoundException;
import org.flightservice.exception.SeatClassNotFoundException;
import org.flightservice.mapper.BookingMapper;
import org.flightservice.repository.BookingRepository;
import org.flightservice.repository.FlightRepository;
import org.flightservice.repository.FlightSeatRepository;
import org.flightservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightSeatRepository flightSeatRepository;

    @Autowired
    private BookingMapper bookingMapper;
    
    @Override
    @Transactional
    public BookingResponseDTO createBooking(BookingRequestDTO request) {
        Flight flight = flightRepository.findById(request.getFlightId())
        .orElseThrow(() ->  new FlightNotFoundException("Flight not found with id: "+request.getFlightId()));

        FlightSeat seat = flightSeatRepository.findByFlightIdAndSeatClass(request.getFlightId(), request.getSeatClass())
        .orElseThrow(()-> new SeatClassNotFoundException("Seat class not available"));

        if (seat.getAvailableSeats() <= 0) {
            throw new SeatClassNotFoundException("seat is not available");
        }

        //building booking entity
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setFlightSeat(seat);
        booking.setPassengerName(request.getPassengerName());
        booking.setPassengerEmail(request.getPassengerEmail());
        booking.setSeatClass(request.getSeatClass());
        booking.setPriceAtBooking(seat.getPrice());
        booking.setBookingTime(LocalDateTime.now());
        booking.setStatus(BookingStatus.CONFIRMED);

        //decrement available seat
        seat.setAvailableSeats(seat.getAvailableSeats()-1);
        flightSeatRepository.save(seat);

        //saving the booking
        return bookingMapper.toDto(bookingRepository.save(booking));
    }
}
