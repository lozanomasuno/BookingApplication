package nj.reservations.service;

import nj.reservations.model.Booking;
import nj.reservations.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;


    public List<Booking> listBookings() {
        return bookingRepository.findAll();
    }


    public Booking getBookingById(Integer id) {
        return bookingRepository.findById(id).orElse(null);
    }


    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }


    public Booking updateBooking(Integer id, Booking booking) {
        if (bookingRepository.existsById(id)) {
            booking.setId(id);
            return bookingRepository.save(booking);
        }
        return null;
    }


    public boolean deleteBooking(Integer id) {
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
