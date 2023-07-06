package com.course_booking_system.course_booking_system.controller;

import com.course_booking_system.course_booking_system.model.Booking;
import com.course_booking_system.course_booking_system.model.Course;
import com.course_booking_system.course_booking_system.model.StarRating;
import com.course_booking_system.course_booking_system.repository.BookingRepository;
import com.course_booking_system.course_booking_system.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    //        http://localhost:8080/courses?byStarRating=FOUR
    public ResponseEntity<List<Course>> getCoursesByVariable(
            @RequestParam(name = "byStarRating", required = false) StarRating starRating,
            @RequestParam(name = "byCustomer", required = false) Long id)
    {
        if (starRating != null){
            return new ResponseEntity<>(courseRepository.findCourseByStarRating(starRating), HttpStatus.OK);
        } else if (id != null) {
            return new ResponseEntity<>(courseRepository.findByBookingsCustomerId(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(courseRepository.findAll(),HttpStatus.OK);
        }
    }
}
