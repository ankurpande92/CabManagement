package com.cms.repository;

import com.cms.entity.Cab;
import com.cms.entity.CabHistory;
import com.cms.util.CabStatus;

import java.util.*;


/**
 * CabDaoImpl is implementation class for cab related operations
 * <p>
 * created by @Ankur Pande
 */
public class CabDaoImpl implements CabDao {

    Map<Integer, Queue<Cab>> cityWiseCabs;
    Map<Integer, Cab> cabDataList;
    Map<Integer, List<CabHistory>> cabHistoryMap;

    public CabDaoImpl() {

        cabDataList = getDataStore();
        cityWiseCabs = getCabDataStore();
        cabHistoryMap = getCabHistoryDataStore();
    }


    @Override
    public void addCab(Cab cab) {


        try {

            Cab newCab = new Cab();

            newCab.setDriverName(cab.getDriverName());
            newCab.setAvalability(cab.getAvalability());
            newCab.setCabId(cab.getCabId());
            newCab.setCity(cab.getCity());

            cabDataList.put(cab.getCabId(), newCab);

            if (cityWiseCabs.containsKey(newCab.getCity().getCityId())){

                Queue<Cab> oldQueue = cityWiseCabs.get(newCab.getCity().getCityId());
                oldQueue.add(newCab);
            }else {
                Queue<Cab> newQueue = new LinkedList<>();
                newQueue.add(newCab);
                cityWiseCabs.put(newCab.getCity().getCityId(), newQueue);
            }
            // Added new cab in system as IDEL state
            List<CabHistory> histories = new ArrayList<>();
            CabHistory cabHistory = new CabHistory();
            cabHistory.setCabStatus(newCab.getAvalability());
            cabHistory.setCabId(newCab.getCabId());
            histories.add(cabHistory);
            cabHistoryMap.put(newCab.getCabId(),histories);

            System.out.println("New cab added Successfully : " + cab.getCabId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Cab getCabBasedOnAvailability(Queue<Cab> cabs) {

        if (cabDataList == null || cabDataList.isEmpty() || cabs==null || cabs.isEmpty()) {
            System.err.println("No Cab Available in system, Please add new cab first !!!");
            throw new RuntimeException("No Cab Available in system, Please add new cab first !!!");
        }
        Cab res = null;
        for (Cab cab : cabs) {
            if (cabDataList.get(cab.getCabId()) != null) {
                if (cabDataList.get(cab.getCabId()).getAvalability().equals(CabStatus.IDLE)) {
                    res = cab;
                    return  res;
                }
            }
        }
        return  res;

    }

    @Override
    public Queue<Cab> getCabBasedOnCity(Integer cityId) {
        Queue<Cab> cabList = cityWiseCabs.get(cityId);

        if (cabList == null || cabList.isEmpty()) {
            System.err.println("No Cab Available in system, Please add new cab first !!!");
            throw new RuntimeException("No Cab Available in system, Please add new cab first !!!");
        }

        return cabList;
    }


    /**
     *
     *
     * handle case of removing cab from quque if it status is on_trip
     * during code review
     * @param cabId
     * @param status
     * @param time
     */
    @Override
    public void changeCabStatus(Integer cabId, CabStatus status, Date time) {

        if (cabDataList == null || cabDataList.isEmpty()) {
            System.err.println("No Cab Available in system, Please add new cab first !!!");
            throw new RuntimeException("No Cab Available in system, Please add new cab first !!!");
        }
        Cab cab = cabDataList.get(cabId);
        Queue<Cab> cabQueue = cityWiseCabs.get(cab.getCity().getCityId());
        if (CabStatus.ON_TRIP.equals(status)) {

            cabQueue.remove(cab);
            cityWiseCabs.put(cab.getCity().getCityId(), cabQueue);
            cab.setStartTime(time);
        } else {
            cab.setEndTime(time);
            //cabQueue.remove(cab);
            cabQueue.add(cab);
            cityWiseCabs.put(cab.getCity().getCityId(), cabQueue);
        }

        if (cabHistoryMap.containsKey(cab.getCabId())){

            List<CabHistory> histories = cabHistoryMap.get(cab.getCabId());
            CabHistory cabHistory = new CabHistory();
            cabHistory.setCabStatus(status);
            cabHistory.setCabId(cab.getCabId());
            histories.add(cabHistory);
            cabHistoryMap.put(cab.getCabId(),histories);

        }else {
            List<CabHistory> histories = new ArrayList<>();
            CabHistory cabHistory = new CabHistory();
            cabHistory.setCabStatus(status);
            cabHistory.setCabId(cab.getCabId());
            histories.add(cabHistory);
            cabHistoryMap.put(cab.getCabId(),histories);
        }
        cab.setAvalability(status);

        cabDataList.put(cabId, cab);
        System.out.println("Cab status got changed to " + status + "for cab id:" + cabId);
    }


    @Override
    public List<CabHistory> getCabHistoryByCabId(int cabId) {

        if (cabHistoryMap == null || cabHistoryMap.isEmpty()) {
            System.err.println("No Cab History Available in system !!!");
            throw new RuntimeException("No Cab History Available in system !!!");
        }

        List<CabHistory> cabHistory = cabHistoryMap.get(cabId);

        if (cabHistory != null) {
            return cabHistory;
        } else {
            System.err.println("CabHistory not Available in system!!!");
            throw new RuntimeException("CabHistory not Available in system!!!");
        }
    }

    /**
     *
     * Below method is been handle during code review
     *
     *
     * Provide insights such as for how much time was a cab idle in a given duration
     * @param cabId
     * @return
     */
    @Override
    public Long cabIdelDuration(Integer cabId){

            Queue<Cab> queue = cityWiseCabs.get(cabId);

            long duration =0;
            long startTime =0;

            while (queue.contains(cabId)) {

                 startTime= System.currentTimeMillis();

            }
            long endtime = System.currentTimeMillis();

            duration =  endtime - startTime;

            return  duration;
    }

    private Map<Integer, Cab> getDataStore() {
        return SingleTonDataRepo.getInstance().cabDataList;
    }

    private Map<Integer, Queue<Cab>> getCabDataStore() {
        return SingleTonDataRepo.getInstance().cityWiseCab;
    }

    private Map<Integer, List<CabHistory>> getCabHistoryDataStore() {
        return SingleTonDataRepo.getInstance().cabHistoryHashMap;
    }
}
