package com.course_booking_system.course_booking_system;

import com.course_booking_system.course_booking_system.model.Booking;
import com.course_booking_system.course_booking_system.model.Course;
import com.course_booking_system.course_booking_system.model.Customer;
import com.course_booking_system.course_booking_system.model.StarRating;
import com.course_booking_system.course_booking_system.repository.BookingRepository;
import com.course_booking_system.course_booking_system.repository.CourseRepository;
import com.course_booking_system.course_booking_system.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
class CourseBookingSystemApplicationTests {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	BookingRepository bookingRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindCourseByStarRating(){
		bookingRepository.deleteAll();
		customerRepository.deleteAll();
		courseRepository.deleteAll();

		Customer customer1 = new Customer("Ben", "Marrakesh", 27);
		customerRepository.save(customer1);

		Course course1 = new Course("Cook Italian", "Rome", StarRating.FOUR);
		courseRepository.save(course1);

		Booking booking1 = new Booking("12/07/23", customer1, course1);
		bookingRepository.save(booking1);

		List<Course> foundCourses = courseRepository.findCourseByStarRating(StarRating.FOUR);

		assertEquals(1, foundCourses.size());
		assertEquals("Cook Italian", foundCourses.get(0).getName());
	}

	@Test
	public void canFindCustomersByCourse(){
		bookingRepository.deleteAll();
		customerRepository.deleteAll();
		courseRepository.deleteAll();

		Customer customer1 = new Customer("Ben", "Marrakesh", 27);
		customerRepository.save(customer1);
		Customer customer2 = new Customer("Jen", "Antarctica", 27);
		customerRepository.save(customer2);


		Course course1 = new Course("Cook Italian", "Rome", StarRating.FOUR);
		courseRepository.save(course1);

		Booking booking1 = new Booking("12/07/23", customer1, course1);
		bookingRepository.save(booking1);

		List<Customer> foundCustomers = customerRepository.findByBookingsCourseId(course1.getId());

		assertEquals("Ben", foundCustomers.get(0).getName());
	}

	@Test
	public void	findByBookingCustomerId(){
		bookingRepository.deleteAll();
		customerRepository.deleteAll();
		courseRepository.deleteAll();

		Customer customer1 = new Customer("Ben", "Marrakesh", 27);
		customerRepository.save(customer1);
		Customer customer2 = new Customer("Jen", "Antarctica", 27);
		customerRepository.save(customer2);


		Course course1 = new Course("Cook Italian", "Rome", StarRating.FOUR);
		Course course2 = new Course("Cook French", "Paris", StarRating.FOUR);
		courseRepository.save(course1);
		courseRepository.save(course2);

		Booking booking1 = new Booking("12/07/23", customer1, course1);
		Booking booking2 = new Booking("13/07/23", customer1, course2);
		bookingRepository.save(booking1);
		bookingRepository.save(booking2);

		List<Course> foundCourses = courseRepository.findByBookingsCustomerId(customer1.getId());
		assertEquals(2, foundCourses.size());
	}

	@Test
	public void	findBookingsByDate(){
		bookingRepository.deleteAll();
		customerRepository.deleteAll();
		courseRepository.deleteAll();

		Customer customer1 = new Customer("Ben", "Marrakesh", 27);
		customerRepository.save(customer1);
		Customer customer2 = new Customer("Jen", "Antarctica", 27);
		customerRepository.save(customer2);


		Course course1 = new Course("Cook Italian", "Rome", StarRating.FOUR);
		Course course2 = new Course("Cook French", "Paris", StarRating.FOUR);
		courseRepository.save(course1);
		courseRepository.save(course2);

		Booking booking1 = new Booking("12/07/23", customer1, course1);
		Booking booking2 = new Booking("13/07/23", customer1, course2);
		bookingRepository.save(booking1);
		bookingRepository.save(booking2);

		List<Booking> foundBookings = bookingRepository.findBookingsByDate("13/07/23");
		assertEquals(1, foundBookings.size());
	}


}
