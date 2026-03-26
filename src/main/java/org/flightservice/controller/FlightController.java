package org.flightservice.controller;

import org.flightservice.dto.FlightResponseDTO;
import org.flightservice.entity.Flight;
import org.flightservice.service.FlightService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/add")
    public ResponseEntity<FlightResponseDTO> addFlight(@RequestBody Flight flight){
        FlightResponseDTO savedFlight = flightService.addFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    @GetMapping("/allFlights")
    public ResponseEntity<List<FlightResponseDTO>> getAllFlights(){
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getAllFlights());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<FlightResponseDTO> getFlightById(@PathVariable Long id){
        FlightResponseDTO getById = flightService.getFlightById(id);
        return ResponseEntity.status(HttpStatus.OK).body(getById);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<FlightResponseDTO> updateFlightDetails(@RequestBody Flight updatedData, @PathVariable Long id){
        FlightResponseDTO updatedFlight = flightService.updateFlight(id, updatedData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedFlight);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<FlightResponseDTO>>searchFlights(
            @RequestParam(required = false) String source,
            @RequestParam(required = false) String destination,
            @PageableDefault(size = 5)
            Pageable pageable){
        Page<FlightResponseDTO> output = flightService.searchFlights(source, destination, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
