package com.cms.repository;

import com.cms.entity.Booking;
import com.cms.entity.Cab;

import java.util.HashMap;
import java.util.Map;


/**
 * BookingDaoImpl is implementation class for booking related operations
 *
 * created by @Ankur Pande
 *
 */
public class BookingDaoImpl implements BookingDao {


    /**
     *
     * Add new booking in the data repo
     *
     * @param booking
     */
    @Override
    public void addBooking(Booking booking) {

        try {

            Booking newBooking = new Booking();

            newBooking.setBookingId(booking.getBookingId());
            newBooking.setCabId(booking.getCabId());
            newBooking.setCustomerId(booking.getCustomerId());
            newBooking.setDistance(booking.getDistance());

            getDataStore().put(booking.getBookingId(), newBooking);

            System.out.println("New cab booking accepted Successfully : " + booking.getBookingId());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     *
     * Get singleton instance
     * @return
     */
    private Map<Integer, Booking> getDataStore(){
        return  SingleTonDataRepo.getInstance().integerBookingMap;
    }

    /**
     *
     * Keep track of booking
     *
     * @return
     */
    @Override
    public int bookingCount(){
       return getDataStore().size();

    }


}
