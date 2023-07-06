package com.course_booking_system.course_booking_system.repository;

import com.course_booking_system.course_booking_system.model.Booking;
import com.course_booking_system.course_booking_system.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    List<Booking> findBookingsByDate(String date);
}
