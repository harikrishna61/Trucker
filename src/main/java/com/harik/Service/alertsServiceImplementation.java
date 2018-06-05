package com.harik.Service;

import com.harik.Entity.Vehicle;
import com.harik.Entity.alerts;
import com.harik.Exception.vehicleNotFoundException;
import com.harik.Repository.alertsRepository;
import com.harik.Repository.vehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class alertsServiceImplementation implements alertsService
{
    @Autowired
    alertsRepository alertsRepo;
    @Autowired
    vehicleRepository vehRepo;

    @Override
    public Iterable<alerts> findAllAlerts()
    {

        return alertsRepo.findHighAlerts();
    }

    @Override
    public Iterable<alerts> findAlertsBYVIn(String vin)
    {
        Optional<alerts> al =alertsRepo.findByVin(vin);
        if(!al.isPresent())
            throw  new vehicleNotFoundException("Vehicle not found: "+vin);
        return alertsRepo.findAllByVin(vin);

    }
}
