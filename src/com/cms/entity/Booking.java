package com.cms.entity;

/**
 * Booking is entity class
 *
 * created by @Ankur Pande
 *
 */
public class Booking {

    private int bookingId;
    private int distance;
    private int cabId;
    private int customerId;
    private int billingAmount;
    private String errorMessage;


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getBookingId() {
        return bookingId;
    }


    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getDistance() {
        return distance;
    }


    public void setDistance(int distance) {
        this.distance = distance;
    }


    public int getCabId() {
        return cabId;
    }


    public void setCabId(int cabId) {
        this.cabId = cabId;
    }


    public int getCustomerId() {
        return customerId;
    }


    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public int getBillingAmount() {
        return billingAmount;
    }


    public void setBillingAmount(int billingAmount) {
        this.billingAmount = billingAmount;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", distance=" + distance +
                ", cabId=" + cabId +
                ", customerId=" + customerId +
                ", billingAmount=" + billingAmount +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
