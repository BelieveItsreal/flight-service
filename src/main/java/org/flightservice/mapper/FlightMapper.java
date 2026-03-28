package org.flightservice.mapper;

import org.flightservice.dto.FlightResponseDTO;
import org.flightservice.dto.FlightSeatResponseDTO;
import org.flightservice.entity.Flight;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper{
    public FlightResponseDTO toDTO(Flight flight) {
        FlightResponseDTO dto= new FlightResponseDTO();
        dto.setId(flight.getId());
        dto.setFlightNumber(flight.getFlightNumber());
        dto.setSourceCode(flight.getSourceCode());
        dto.setSourceCity(flight.getSourceCity());
        dto.setDestinationCode(flight.getDestinationCode());
        dto.setDestinationCity(flight.getDestinationCity());
        dto.setDepartureTime(flight.getDepartureTime());
        dto.setArrivalTime(flight.getArrivalTime());
        dto.setSeatClasses(flight.getSeatClasses().stream()
        .map(seat -> {
            FlightSeatResponseDTO seatDto = new FlightSeatResponseDTO();
            seatDto.setId(seat.getId());
            seatDto.setSeatClass(seat.getSeatClass());
            seatDto.setAvailableSeats(seat.getAvailableSeats());
            seatDto.setPrice(seat.getPrice());
            return seatDto;
        }).toList());
        return dto;
    }
    
}
