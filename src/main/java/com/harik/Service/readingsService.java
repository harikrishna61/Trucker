package com.harik.Service;

import com.harik.Entity.Readings;
import com.harik.Entity.Vehicle;

public interface readingsService
{
    public Readings saveOrUpdateReadings(Readings readings);

    Iterable<Readings> findLocationByVin(String vin);

}
