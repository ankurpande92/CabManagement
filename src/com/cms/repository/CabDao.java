package com.cms.repository;

import com.cms.entity.Cab;
import com.cms.entity.CabHistory;
import com.cms.util.CabStatus;

import java.util.Date;
import java.util.List;
import java.util.Queue;

/**
 * CabDao is interface class
 *
 * created by @Ankur Pande
 *
 */
public interface CabDao {

    void addCab(Cab cab);

    Cab  getCabBasedOnAvailability(Queue<Cab> cabs);

    Queue<Cab> getCabBasedOnCity(Integer cityId);

    void changeCabStatus(Integer cabId, CabStatus status, Date time);

    List<CabHistory> getCabHistoryByCabId(int cabId);

    // handle during core review
    Long cabIdelDuration(Integer cabId);

}
