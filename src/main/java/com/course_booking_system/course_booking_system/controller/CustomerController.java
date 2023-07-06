package com.course_booking_system.course_booking_system.controller;

import com.course_booking_system.course_booking_system.model.Customer;
import com.course_booking_system.course_booking_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

//    @GetMapping(value = "/")
}
