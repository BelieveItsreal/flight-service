package org.flightservice.service.impl;

import org.flightservice.dto.FlightResponseDTO;
import org.flightservice.entity.Flight;
import org.flightservice.exception.FlightNotFoundException;
import org.flightservice.mapper.FlightMapper;
import org.flightservice.repository.FlightRepository;
import org.flightservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightMapper flightMapper;

    @Override
    public FlightResponseDTO addFlight(Flight flight) {
        flight.getSeatClasses().forEach(seat -> seat.setFlight(flight));    
        return flightMapper.toDTO(flightRepository.save(flight));
    }

    @Override
    public List<FlightResponseDTO> getAllFlights() {
        return  flightRepository.findAll().stream().map(flight -> flightMapper.toDTO(flight)).toList();
    }

    @Override
    public FlightResponseDTO getFlightById(Long id) {
        return flightMapper.toDTO(flightRepository.findById(id).orElseThrow(() ->
                new FlightNotFoundException("Flight not found with id: " + id)));
    }

    @Override
    public FlightResponseDTO updateFlight(Long id, Flight updatedFlightData) {
        Flight existing = flightRepository.findById(id).orElseThrow(() ->
                new FlightNotFoundException("Flight not found with id: " + id));
        existing.setFlightNumber(updatedFlightData.getFlightNumber());
        existing.setSourceCode(updatedFlightData.getSourceCode());
        existing.setSourceCity(updatedFlightData.getSourceCity());
        existing.setDestinationCode(updatedFlightData.getDestinationCode());
        existing.setDestinationCity(updatedFlightData.getDestinationCity());
        existing.setDepartureTime(updatedFlightData.getDepartureTime());
        existing.setArrivalTime(updatedFlightData.getArrivalTime());
        return flightMapper.toDTO(flightRepository.save(existing));
    }

    @Override
    public void deleteFlight(Long id) {
        Flight deleteFlight = flightRepository.findById(id).orElseThrow(() ->
                new FlightNotFoundException("Flight not found with id: " + id));
        flightRepository.delete(deleteFlight);
    }

    @Override
    public Page<FlightResponseDTO> searchFlights(String source, String destination, Pageable pageable) {
        List<String> allowedField = List.of("departureTime", "arrivalTime");
        for (Sort.Order order : pageable.getSort()) {
            if (!allowedField.contains(order.getProperty())) {
                throw new IllegalArgumentException("Invalid sort field: " + order.getProperty());
            }
        }
        Page<Flight> result;
        if (source != null && destination != null) {
            result = flightRepository.findBySourceCodeAndDestinationCode(source, destination, pageable);
        } else if (source != null) {
            result = flightRepository.findBySourceCode(source, pageable);
        } else if (destination != null) {
            result = flightRepository.findByDestinationCode(destination, pageable);
        } else {
            result = flightRepository.findAll(pageable);
        }
        if (result.isEmpty()) {
            throw new FlightNotFoundException("No flights found for given criteria");
        }
        return result.map(flight -> flightMapper.toDTO(flight));
    }
}
