package com.cms.repository;

import com.cms.entity.City;

import java.util.Map;

/**
 * CityDaoImpl is implementation class for city related operations
 *
 * created by @Ankur Pande
 *
 */
public class CityDaoImpl implements CityDao {


    Map<Integer, City> cityDataList ;

    public CityDaoImpl(){

        cityDataList = getDataStore();
    }

    @Override
    public void addCity(City city) {

        try {

            City newCity = new City();

            newCity.setCityName(city.getCityName());
            newCity.setCityId(city.getCityId());

            cityDataList.put(city.getCityId(), newCity);

            System.out.println("New city added Successfully : " + city.getCityId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Map<Integer, City> getDataStore(){
        return  SingleTonDataRepo.getInstance().cityDataList;
    }
}
