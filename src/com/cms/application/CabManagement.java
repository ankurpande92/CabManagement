package com.cms.application;

import com.cms.entity.*;
import com.cms.repository.*;
import com.cms.service.CabBookService;
import com.cms.util.CabStatus;

import java.util.Date;
import java.util.List;

/**
 * CabManagement is Main class
 *
 * created by @Ankur Pande
 *
 */

public class CabManagement {

    /**
     *
     * Main Method
     *
     * @param args
     */
    public static void main(String[] args) {

        // Add City database
        City cityOne = new City();
        cityOne.setCityId(411033);
        cityOne.setCityName("Pune");

        City cityTwo = new City();
        cityTwo.setCityId(411044);
        cityTwo.setCityName("Mumbai");

        City cityThree = new City();
        cityThree.setCityId(411050);
        cityThree.setCityName("Abad");

        CityDao cityDao = new CityDaoImpl();
        cityDao.addCity(cityOne);
        cityDao.addCity(cityTwo);
        cityDao.addCity(cityThree);

        // Add customer database
        Customer customerOne = new Customer();
        customerOne.setCustomerName("Ankur");
        customerOne.setCustomerId(1111);
        customerOne.setCustomerCity(cityOne);

        Customer customerThree = new Customer();
        customerThree.setCustomerName("Xyz");
        customerThree.setCustomerId(3333);
        customerThree.setCustomerCity(cityThree);


        Customer customerTwo = new Customer();
        customerTwo.setCustomerName("Test");
        customerTwo.setCustomerId(2222);
        customerTwo.setCustomerCity(cityTwo);

        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.addCustomer(customerOne);
        customerDao.addCustomer(customerTwo);
        customerDao.addCustomer(customerThree);


        // Add cab details
        Cab cabOne = new Cab();
        cabOne.setCabId(1);
        cabOne.setDriverName("Amar");
        cabOne.setCity(cityOne);
        cabOne.setAvalability(CabStatus.IDLE);

        Cab cabTwo = new Cab();
        cabTwo.setCabId(2);
        cabTwo.setDriverName("Prem");
        cabTwo.setCity(cityTwo);
        cabTwo.setAvalability(CabStatus.IDLE);

        Cab cabThree = new Cab();
        cabThree.setCabId(3);
        cabThree.setDriverName("Vinayak");
        cabThree.setCity(cityTwo);
        cabThree.setAvalability(CabStatus.IDLE);


        Cab cabFour = new Cab();
        cabFour.setCabId(4);
        cabFour.setDriverName("Sagar");
        cabFour.setCity(cityTwo);
        cabFour.setAvalability(CabStatus.IDLE);

        CabDao cabDao = new CabDaoImpl();
        cabDao.addCab(cabOne);
        cabDao.addCab(cabTwo);
        cabDao.addCab(cabThree);
        cabDao.addCab(cabFour);

        CabBookService cabBookService = new CabBookService();
        Booking bookingForCustomerOne = cabBookService.bookCab(9, customerOne.getCustomerId());
        if (bookingForCustomerOne.getCabId()!=0) {
            cabBookService.endTrip(bookingForCustomerOne.getCabId());
        }
        bookingForCustomerOne = cabBookService.bookCab(10, customerOne.getCustomerId());
        if (bookingForCustomerOne.getCabId()!=0) {
            cabBookService.endTrip(bookingForCustomerOne.getCabId());
        }

       /* Booking bookingForCustomerTwo = cabBookService.bookCab(9, customerTwo.getCustomerId());
        if (bookingForCustomerTwo.getCabId()!=0) {
            cabBookService.endTrip(bookingForCustomerTwo.getCabId());
        }
        bookingForCustomerTwo = cabBookService.bookCab(100, customerTwo.getCustomerId());
        if (bookingForCustomerTwo.getCabId()!=0) {
            cabBookService.endTrip(bookingForCustomerTwo.getCabId());
        }
        cabBookService.bookCab(120, customerTwo.getCustomerId());
        cabBookService.bookCab(150, customerTwo.getCustomerId());*/

        //cabBookService.bookCab(50, customerThree.getCustomerId());

        List<CabHistory> histories =  cabDao.getCabHistoryByCabId(cabOne.getCabId());
        System.out.println("Below is the history for cabId=" + cabOne.getCabId());
        for(CabHistory cabHistory: histories) {
            System.out.println(cabHistory.toString());
        }

    }
}


