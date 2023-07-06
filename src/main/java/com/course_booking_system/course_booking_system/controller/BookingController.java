package com.course_booking_system.course_booking_system.controller;

import com.course_booking_system.course_booking_system.model.Booking;
import com.course_booking_system.course_booking_system.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public List<Booking> getAllBookings(){
        return bookingRepository.findAll();
    }

}
