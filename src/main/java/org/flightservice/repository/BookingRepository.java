package org.flightservice.repository;

import java.util.List;

import org.flightservice.entity.Booking;
import org.flightservice.enums.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long>{
    List<Booking> findByUserIdAndStatus(long id, BookingStatus status);
    void deleteByUserId(long id);

    List<Booking> findByUserId(Long userId);
}
