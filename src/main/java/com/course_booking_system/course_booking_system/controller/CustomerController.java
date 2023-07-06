package com.course_booking_system.course_booking_system.controller;

import com.course_booking_system.course_booking_system.model.Course;
import com.course_booking_system.course_booking_system.model.Customer;
import com.course_booking_system.course_booking_system.model.StarRating;
import com.course_booking_system.course_booking_system.repository.CourseRepository;
import com.course_booking_system.course_booking_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;


    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getCustomersByCourse(@RequestParam(name = "byCourse", required = false) Long id){
        if (id != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseId(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
        }
    }
}
