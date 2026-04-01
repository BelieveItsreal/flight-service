package org.flightservice.mapper;

import org.flightservice.dto.BookingResponseDTO;
import org.flightservice.entity.Booking;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper {
    public BookingResponseDTO toDto(Booking booking){
        BookingResponseDTO dto = new BookingResponseDTO();
        dto.setBookingId(booking.getId());
        dto.setFlightNumber(booking.getFlight().getFlightNumber());
        dto.setSourceCity(booking.getFlight().getSourceCity());
        dto.setDestinationCity(booking.getFlight().getDestinationCity());
        dto.setDepartureTime(booking.getFlight().getDepartureTime());
        dto.setArrivalTime(booking.getFlight().getArrivalTime());
        dto.setSeatClass(booking.getSeatClass());
        dto.setPassengerName(booking.getUser().getName());
        dto.setPassengerEmail(booking.getUser().getEmail());
        dto.setPassportNumber(booking.getUser().getPassportNumber());
        dto.setPriceAtBooking(booking.getPriceAtBooking());
        dto.setBookingTime(booking.getBookingTime());
        dto.setStatus(booking.getStatus());
        return dto;
    }
}
