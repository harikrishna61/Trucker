package com.harik.Service;

import com.harik.Entity.Readings;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class scratch

{
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

        LocalDateTime veh = LocalDateTime.parse("2018-06-03T03:42:25.096Z",formatter);


        Duration duration = Duration.between(now, veh);

        long diff = Math.abs(duration.toMinutes());

        System.out.println(veh);

        System.out.println(diff);




        //        List<Readings> readings = readRepo.findAllByVin(vin);
//        if(readings.isEmpty())
//            throw  new vehicleNotFoundException("Vehicle not found: "+vin);
//
//        List<StringBuilder> result= new ArrayList<>();
//
//        for(Readings r : readings)
//        {
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime vehDiff = LocalDateTime.parse(r.getTimestamp(),formatter);
//        Duration duration = Duration.between(now, vehDiff);
//
//        long diff = Math.abs(duration.toMinutes());
//        if(diff<=400)
//        {
//            StringBuilder location = new StringBuilder("Latitude:"+r.getLatitude()+" Longitude:"+r.getLongitude());
//            result.add(location);
//        }
//        }
//
//      return result;

    }
}
