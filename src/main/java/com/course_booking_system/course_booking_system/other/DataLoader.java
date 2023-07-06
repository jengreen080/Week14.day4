package com.course_booking_system.course_booking_system.other;

import com.course_booking_system.course_booking_system.model.Booking;
import com.course_booking_system.course_booking_system.model.Course;
import com.course_booking_system.course_booking_system.model.Customer;
import com.course_booking_system.course_booking_system.model.StarRating;
import com.course_booking_system.course_booking_system.repository.BookingRepository;
import com.course_booking_system.course_booking_system.repository.CourseRepository;
import com.course_booking_system.course_booking_system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    BookingRepository bookingRepository;

    public DataLoader(){}

    public void run(ApplicationArguments args){
        Customer customer1 = new Customer("Ben", "Marrakesh", 27);
        customerRepository.save(customer1);

        Course course1 = new Course("Cook Italian", "Rome", StarRating.FOUR);
        courseRepository.save(course1);

        Booking booking1 = new Booking("12/07/23", customer1, course1);
        bookingRepository.save(booking1);
    }
}
