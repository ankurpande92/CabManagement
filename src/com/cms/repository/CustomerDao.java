package com.cms.repository;

import com.cms.entity.Customer;

/**
 * CustomerDao is interface class
 *
 * created by @Ankur Pande
 *
 */
public interface CustomerDao {

    void addCustomer(Customer customer);

    Customer getCustomer(int customerId);

}
