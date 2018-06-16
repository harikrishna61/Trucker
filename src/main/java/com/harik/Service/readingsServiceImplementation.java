package com.harik.Service;

import com.harik.Alerts.alertCoolantLights;
import com.harik.Alerts.alertFuelVolume;
import com.harik.Alerts.alertRPM;
import com.harik.Alerts.alertTirePressure;
import com.harik.Entity.Readings;
import com.harik.Entity.Tires;
import com.harik.Entity.Vehicle;
import com.harik.Entity.alerts;
import com.harik.Exception.vehicleNotFoundException;
import com.harik.Message.EmailAwsSESImplementation;
import com.harik.Message.smsAwsSNSImplementation;
import com.harik.Repository.alertsRepository;
import com.harik.Repository.readingsRepository;
import com.harik.Repository.tireRepository;
import com.harik.Repository.vehicleRepository;
import org.easyrules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Optional;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

@Service
public class readingsServiceImplementation implements readingsService
{
    @Autowired
    readingsRepository readRepo;

    @Autowired
    vehicleRepository vehRepo;

    @Autowired
    alertsRepository alertRepo;

    @Autowired
    tireRepository tireRepo;

    //
    @Autowired
    EmailAwsSESImplementation email;

    @Autowired
    smsAwsSNSImplementation sms;

    //
    @Override
    @Transactional
    public Readings saveOrUpdateReadings(Readings readings) throws IOException {
        readRepo.save(readings);
        Optional<Vehicle> v=vehRepo.findById(readings.getVin());
        Optional<Tires> tire = Optional.ofNullable(readings.getTires());

        alertFuelVolume volumeAlert = new alertFuelVolume(v.get().getMaxFuelVolume(),readings.getFuelVolume());

        alertRPM rpmAlert= new alertRPM(v.get().getRedlineRpm(),readings.getEngineRpm());

        alertCoolantLights coolantLights=new alertCoolantLights(readings.isCheckEngineLightOn(),readings.isEngineCoolantLow());

        alertTirePressure alertTire = new alertTirePressure(tire.get().getFrontLeft(),tire.get().getFrontRight(),tire.get().getRearLeft(),tire.get().getRearRight());

        RulesEngine rulesEngine = aNewRulesEngine()
                .withSkipOnFirstAppliedRule(true)
                .withSilentMode(true)
                .build();

        rulesEngine.registerRule(volumeAlert);
        rulesEngine.registerRule(rpmAlert);
        rulesEngine.registerRule(coolantLights);
        rulesEngine.registerRule(alertTire);

        rulesEngine.fireRules();


        if(volumeAlert.isResult()) {
            alerts alerts = new alerts();
            alerts.setVin(readings.getVin());
            alerts.setType("Fuel Volume");
            alerts.setPriority("MEDIUM");
            alertRepo.save(alerts);

        }
        if(rpmAlert.isResult())
        {
            alerts alerts = new alerts();
            alerts.setVin(readings.getVin());
            alerts.setType("Red Line RPM");
            alerts.setPriority("HIGH");
            alertRepo.save(alerts);
            //
            //Set from and to email id
            email.setFrom(" ");
            email.setTo(" ");
            email.setBody("Your vehicle "+v.get().getModel()+", vin:"+readings.getVin()+"has current engine RPM > redLineRPM");
            email.setSubject("High Priority alert ");
            email.sendAlert();

            //Set phone Number
            sms.setMessage("vehicle's engine RPM > redLineRPM ");
            sms.setPhoneNumber(" ");
            sms.sendAlert();
            //
        }
        if(coolantLights.isResult())
        {
            alerts alerts = new alerts();
            alerts.setVin(readings.getVin());
            alerts.setType("Engine Coolant=true || lights =true");
            alerts.setPriority("LOW");
            alertRepo.save(alerts);
        }
        if(alertTire.isResult())
        {
            alerts alerts = new alerts();
            alerts.setVin(readings.getVin());
            alerts.setType("Tires pressure not in 32 and 36");
            alerts.setPriority("LOW");
            alertRepo.save(alerts);
        }
        return readings;

    }

    @Override
    @Transactional
    public Iterable<Readings> findLocationByVin(String vin)
    {
        Optional<Vehicle> veh =vehRepo.findById(vin);
        if(!veh.isPresent())
            throw  new vehicleNotFoundException("Vehicle not found: "+vin);
        return readRepo.findLocationByVin(vin);
    }
}
