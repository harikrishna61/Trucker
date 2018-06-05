package com.harik.Controller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.harik.Entity.Readings;
import com.harik.Entity.Vehicle;
import com.harik.Service.vehicleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/vehicles")
@Api(description = "Vehicle related End points")
public class vehicleController
{
    @Autowired
     vehicleService vehservice;

    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "PUT(Saves) all Vehicles details into data base ",notes="returns all saved vehicle's details")
    @ApiResponses(value = {
            @ApiResponse( code=200 ,message = "OK"),
            @ApiResponse(code=500,message = "Server Not Found")
    })
    public Iterable<Vehicle> saveAll(@RequestBody Iterable<Vehicle> vehicles)
    {
        System.out.println("co");
        return vehservice.saveAll(vehicles);
    }

    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "GET,Finds all vehicles ",notes="returns all vehicles ")
    @ApiResponses(value = {
            @ApiResponse( code=200 ,message = "OK"),
            @ApiResponse(code=500,message = "Server Not Found")
    })
    public Iterable<Vehicle> findAllVehicles()
    {
        return vehservice.findAllVehicles();
    }


}
