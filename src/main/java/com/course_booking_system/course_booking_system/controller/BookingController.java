package com.course_booking_system.course_booking_system.controller;

import com.course_booking_system.course_booking_system.model.Booking;
import com.course_booking_system.course_booking_system.model.Customer;
import com.course_booking_system.course_booking_system.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;


    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookingsByDate(@RequestParam(name = "byDate", required = false) String date){
        if (date != null) {
            return new ResponseEntity<>(bookingRepository.findBookingsByDate(date), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(bookingRepository.findAll(), HttpStatus.OK);
        }
    }

}
