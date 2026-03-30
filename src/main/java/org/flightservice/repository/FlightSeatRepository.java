package org.flightservice.repository;

import java.util.Optional;

import org.flightservice.entity.FlightSeat;
import org.flightservice.enums.SeatClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightSeatRepository extends JpaRepository<FlightSeat, Long>{
    Optional<FlightSeat> findByFlightIdAndSeatClass(Long flightId, SeatClass seatClass);
}
