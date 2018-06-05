package com.harik.Service;

import com.harik.Entity.Readings;
import com.harik.Entity.Vehicle;
import com.harik.Exception.vehicleNotFoundException;
import com.harik.Repository.readingsRepository;
import com.harik.Repository.vehicleRepository;
import com.harik.Service.vehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class vehicleServiceImplentation implements vehicleService
{
    @Autowired
     vehicleRepository vehrepo;



    @Override
    @Transactional
    public Iterable<Vehicle> saveAll(Iterable<Vehicle> vehicles)
    {
        for(Vehicle veh : vehicles)
        {
             if(vehrepo.findById(veh.getVin()).equals(veh))
            {
                continue;
            }
            else
                 vehrepo.save(veh);
        }


        return vehrepo.saveAll(vehicles);
    }

    @Override
    public Iterable<Vehicle> findAllVehicles()
    {
        return vehrepo.findAll();
    }




}
