package nj.reservations.service;

import nj.reservations.model.Booking;

import java.util.List;

public interface IBookingService {
    public List<Booking> listBookings();

    public Booking findBooking(Integer idBooking);

    public void saveBooking(Booking booking);

    public void deleteBooking(Integer idBooking);
}
