package org.flightservice.service;

import org.flightservice.entity.Flight;
import org.flightservice.exception.FlightNotFoundException;
import org.flightservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public Flight addFlight(Flight flight){
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id){
        return flightRepository.findById(id).orElseThrow(()->
                new FlightNotFoundException("Flight not found with id: " +id));
    }

    public Flight updateFlight(Long id, Flight updatedFlightData){
        Flight existing = flightRepository.findById(id).orElseThrow(()->
                new FlightNotFoundException("Flight not found with id: " +id));
        existing.setFlightNumber(updatedFlightData.getFlightNumber());
        existing.setSourceCode(updatedFlightData.getSourceCode());
        existing.setSourceCity(updatedFlightData.getSourceCity());
        existing.setDestinationCode(updatedFlightData.getDestinationCode());
        existing.setDestinationCity(updatedFlightData.getDestinationCity());
        existing.setDepartureTime(updatedFlightData.getDepartureTime());
        existing.setArrivalTime(updatedFlightData.getArrivalTime());
        existing.setAvailableSeats(updatedFlightData.getAvailableSeats());
        existing.setPrice(updatedFlightData.getPrice());
        return flightRepository.save(existing);
    }

    public void deleteFlight(Long id){
        Flight deleteFlight = flightRepository.findById(id).orElseThrow(()->
                new FlightNotFoundException("Flight not found with id: " + id));
        flightRepository.delete(deleteFlight);
    }

    public Page<Flight> searchFlights(String source, String destination, Pageable pageable){
        List<String> allowedField = List.of("price", "departureTime", "arrivalTime");
        for (Sort.Order order : pageable.getSort()){
            if (!allowedField.contains(order.getProperty())){
                throw new IllegalArgumentException("Invalid sort field: "+order.getProperty());
            }
        }
        Page<Flight>result;
        if (source != null && destination != null){
            result = flightRepository.findBySourceCodeAndDestinationCode(source, destination, pageable);
        } else if (source != null) {
            result = flightRepository.findBySourceCode(source, pageable);
        } else if (destination != null) {
            result = flightRepository.findByDestinationCode(destination, pageable);
        }else {
            result = flightRepository.findAll(pageable);
        }
        if (result.isEmpty()){
            throw new FlightNotFoundException("No flights found for given criteria");
        }
        return result;
    }
}

