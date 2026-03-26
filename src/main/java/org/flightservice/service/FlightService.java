package org.flightservice.service;

import org.flightservice.dto.FlightResponseDTO;
import org.flightservice.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FlightService {

    FlightResponseDTO addFlight(Flight flight);

    List<FlightResponseDTO> getAllFlights();

    FlightResponseDTO getFlightById(Long id);

    FlightResponseDTO updateFlight(Long id, Flight updatedFlightData);

    void deleteFlight(Long id);

    Page<FlightResponseDTO> searchFlights(String source, String destination, Pageable pageable);

    
}
