package com.course_booking_system.course_booking_system.repository;

import com.course_booking_system.course_booking_system.model.Course;
import com.course_booking_system.course_booking_system.model.Customer;
import com.course_booking_system.course_booking_system.model.StarRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findCourseByStarRating(StarRating starRating);
    List<Course> findByBookingsCustomerId(Long id);
}
