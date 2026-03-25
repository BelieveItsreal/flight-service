package org.flightservice.repository;

import org.flightservice.entity.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    Page<Flight>findBySourceCode(String sourceCode, Pageable pageable);
    Page<Flight>findByDestinationCode(String destinationCode, Pageable pageable);
    Page<Flight>findBySourceCodeAndDestinationCode(String sourceCode, String destinationCode, Pageable pageable);
}
