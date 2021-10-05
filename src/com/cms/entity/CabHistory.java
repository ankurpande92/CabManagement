package com.cms.entity;

import com.cms.util.CabStatus;

/**
 * Cab is entity class
 * created by @Ankur Pande
 */
public class CabHistory {

    private Integer cabId;
    private CabStatus cabStatus;

    public CabStatus getCabStatus() {
        return cabStatus;
    }

    public void setCabStatus(CabStatus cabStatus) {
        this.cabStatus = cabStatus;
    }

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    @Override
    public String toString() {
        return "CabHistory{" +
                "cabId=" + cabId +
                ", cabStatus=" + cabStatus +
                '}';
    }
}
