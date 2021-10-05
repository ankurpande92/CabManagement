package com.cms.repository;

import com.cms.entity.Customer;

import java.util.Map;

/**
 * CustomerDaoImpl is customerDao implementation class to have all customer related operations
 *
 * created by @Ankur Pande
 *
 */
public class CustomerDaoImpl implements CustomerDao {


    Map<Integer, Customer> customerHashMap;

    public CustomerDaoImpl() {
        customerHashMap = getDataStore();
    }

    @Override
    public void addCustomer(Customer customer) {

        try {
            Customer newCustomer = new Customer();

            newCustomer.setCustomerId(customer.getCustomerId());
            newCustomer.setCustomerName(customer.getCustomerName());

            customerHashMap.put(customer.getCustomerId(), customer);

            System.out.println("New customer added Successfully : " + customer.getCustomerId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomer(int customerId) {

        if (customerHashMap == null || customerHashMap.isEmpty()) {
            System.err.println("No Customer Available in system, Please add Customer !!!");
            throw new RuntimeException("No Customer Available in system, Please add Customer !!!");
        }

        Customer customer = customerHashMap.get(customerId);

        if (customer != null) {
            return customer;
        } else {
            System.err.println("Customer not Available in system, Please add customer !!!");
            throw new RuntimeException("Customer not Available in system, Please add customer !!!");
        }
    }


    private Map<Integer, Customer> getDataStore() {
        return SingleTonDataRepo.getInstance().customerHashMap;
    }

}
