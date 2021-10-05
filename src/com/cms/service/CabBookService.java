package com.cms.service;

import com.cms.entity.Booking;
import com.cms.entity.Cab;
import com.cms.entity.Customer;
import com.cms.repository.BookingDao;
import com.cms.repository.BookingDaoImpl;
import com.cms.repository.CabDaoImpl;
import com.cms.repository.CustomerDaoImpl;
import com.cms.util.CabStatus;

import java.util.Date;
import java.util.Queue;

/**
 * CabBookService This is service to book a cab
 *
 * created by @Ankur Pande
 *
 */
public class CabBookService {

    public static Integer BOOKING_VALUE = 100;
    /**
     *
     * bookCab is function which book a cab for customer
     *
     * @param distance
     * @param customerId
     */
    public Booking bookCab(int distance, int customerId) {

        // First get Customer data from repository
        CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();
        Customer customer = customerDaoImpl.getCustomer(customerId);

        CabDaoImpl cabDao = new CabDaoImpl();

        // Check that customer has cab service provided in his/her city
        Queue<Cab> cabBasedOnCity = cabDao.getCabBasedOnCity(customer.getCustomerCity().getCityId());

        if (cabBasedOnCity == null || cabBasedOnCity.isEmpty()) {
            System.err.println("Booking is not confirmed, Since no cabs service is available in your city !!!");
        }
        BookingDao bookingdao = new BookingDaoImpl();
        Booking book = new Booking();

        // Check cab is available or not
        Cab cabBasedOnAvailability = cabDao.getCabBasedOnAvailability(cabBasedOnCity);
        if (cabBasedOnAvailability==null){
            book.setCabId(0);
            book.setErrorMessage("Booking is not confirmed, Since no cabs are available at the moment, Please try after some time !!!");
        }else {

            book.setCabId(cabBasedOnAvailability.getCabId());
            book.setDistance(distance);
            book.setCustomerId(customerId);
            book.setBookingId(bookingdao.bookingCount()+1);
            // calculate booking
            book.setBillingAmount(BOOKING_VALUE + (distance * 25));
            bookingdao.addBooking(book);

            // change status of that cab once booked
            cabDao.changeCabStatus(book.getCabId(), CabStatus.ON_TRIP, new Date());

        }
        System.out.println("Your cab status with booking detail " + book.toString());
        return  book;

    }


    public void endTrip(int cabId){
        CabDaoImpl cabDao = new CabDaoImpl();
        cabDao.changeCabStatus(cabId, CabStatus.IDLE, new Date());
    }

}
