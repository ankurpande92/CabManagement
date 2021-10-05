package com.cms.entity;

/**
 * Customer is entity class
 *
 * created by @Ankur Pande
 *
 */
public class Customer {

    private int customerId;
    private String customerName;
    private City customerCity;


    public City getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(City customerCity) {
        this.customerCity = customerCity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;

    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerCity=" + customerCity +
                '}';
    }
}
