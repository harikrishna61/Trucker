package com.harik.Service;

import com.harik.Entity.Readings;
import com.harik.Entity.Vehicle;

public interface vehicleService
{
     Iterable<Vehicle> saveAll(Iterable<Vehicle> vehicles);

     Iterable<Vehicle> findAllVehicles();

}
