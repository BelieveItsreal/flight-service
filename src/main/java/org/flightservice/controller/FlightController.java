package org.flightservice.controller;

import org.flightservice.entity.Flight;
import org.flightservice.service.FlightService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight){
        Flight savedFlight = flightService.addFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFlight);
    }

    @GetMapping("/allFlights")
    public ResponseEntity<List<Flight>> getAllFlights(){
        return ResponseEntity.status(HttpStatus.OK).body(flightService.getAllFlights());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        Flight getById = flightService.getFlightById(id);
        if (getById == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(getById);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Flight> updateFlightDetails(@RequestBody Flight updatedData, @PathVariable Long id){
        Flight updatedFlight = flightService.updateFlight(id, updatedData);
        return ResponseEntity.status(HttpStatus.OK).body(updatedFlight);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Flight>>searchFlights(
            @RequestParam(required = false) String source,
            @RequestParam(required = false) String destination,
            @PageableDefault(size = 5, sort = "price", direction = Sort.Direction.ASC)
            Pageable pageable){
        Page<Flight> output = flightService.searchFlights(source, destination, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(output);
    }
}
