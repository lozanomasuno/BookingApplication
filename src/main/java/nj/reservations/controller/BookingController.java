package nj.reservations.controller;

import nj.reservations.model.Booking;
import nj.reservations.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("booking-app")
@CrossOrigin(value = "http://localhost:5173/")
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;


    @GetMapping("/bookings")
    public List<Booking> getBookings() {
        List<Booking> bookingList = this.bookingService.listBookings();
        logger.info("Obtained bookings");
        bookingList.forEach(booking -> logger.info(booking.toString()));
        return bookingList;
    }


    @GetMapping("/bookings/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
        Booking booking = this.bookingService.getBookingById(id);
        if (booking == null) {
            logger.error("Booking not found with ID: " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Obtained booking with ID: " + id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }


    @PostMapping("/bookings")
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking newBooking = this.bookingService.createBooking(booking);
        logger.info("Created new booking with ID: " + newBooking.getId());
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }


    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Integer id, @RequestBody Booking booking) {
        Booking updatedBooking = this.bookingService.updateBooking(id, booking);
        if (updatedBooking == null) {
            logger.error("Failed to update booking with ID: " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Updated booking with ID: " + id);
        return new ResponseEntity<>(updatedBooking, HttpStatus.OK);
    }


    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
        boolean isDeleted = this.bookingService.deleteBooking(id);
        if (!isDeleted) {
            logger.error("Failed to delete booking with ID: " + id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        logger.info("Deleted booking with ID: " + id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
