package com.cms.repository;

import com.cms.entity.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * SingleTonDataRepo is singleton class to have single point of all data repos
 *
 * created by @Ankur Pande
 *
 */

public class SingleTonDataRepo {
    private static SingleTonDataRepo instance;
    public Map<Integer, Booking> integerBookingMap;
    public Map<Integer, Cab> cabDataList;
    public Map<Integer, City> cityDataList;
    public Map<Integer, Customer> customerHashMap;
    public Map<Integer, List<CabHistory>> cabHistoryHashMap;
    public Map<Integer, Queue<Cab>> cityWiseCab;

    private SingleTonDataRepo()
    {
        integerBookingMap= new HashMap<>();
        cabDataList = new HashMap<>();
        cityDataList = new HashMap<>();
        customerHashMap = new HashMap<>();
        cityWiseCab = new HashMap<>();
        cabHistoryHashMap = new HashMap<>();
    }

    //method to return instance of class
    public static SingleTonDataRepo getInstance()
    {
        if (instance == null)
        {
            // if instance is null, initialize
            instance = new SingleTonDataRepo();
        }
        return instance;
    }
}
