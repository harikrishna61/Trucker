package com.harik.Service;

import com.harik.Entity.Readings;
import com.harik.Entity.Vehicle;

import java.io.IOException;

public interface readingsService
{
    public Readings saveOrUpdateReadings(Readings readings) throws IOException;

    Iterable<Readings> findLocationByVin(String vin);

}
