package com.course_booking_system.course_booking_system.repository;

import com.course_booking_system.course_booking_system.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
