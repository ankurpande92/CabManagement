package com.cms.repository;

import com.cms.entity.Booking;

/**
 * BookingDao is interface class
 *
 * created by @Ankur Pande
 *
 */
public interface BookingDao {

    void addBooking(Booking booking);
    int bookingCount();


}
