package com.cms.entity;

import com.cms.util.CabStatus;

import java.util.Date;

/**
 * Cab is entity class
 * created by @Ankur Pande
 */
public class Cab {

    private int cabId;
    private String driverName;
    private City city;
    private CabStatus avalability;
    private Date startTime;
    private Date endTime;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setCabId(int cabId) {
        this.cabId = cabId;
    }


    public CabStatus getAvalability() {
        return avalability;
    }

    public int getCabId() {
        return cabId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    public void setAvalability(CabStatus avalability) {
        this.avalability = avalability;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "cabId=" + cabId +
                ", driverName='" + driverName + '\'' +
                ", avalability=" + avalability +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
