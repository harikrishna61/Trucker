package com.harik.Controller;

import com.harik.Entity.Readings;
import com.harik.Entity.Vehicle;
import com.harik.Service.readingsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/readings")
@Api(description = "Readings related End Points")
public class readingsController
{

    @Autowired
    private readingsService readserv;

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Post  readings into datta base ",notes="returns all posted readings")
    @ApiResponses(value = {
            @ApiResponse( code=200 ,message = "OK"),
            @ApiResponse(code=500,message = "Server Not Found")
    })
    @CrossOrigin(origins = "http://mocker.egen.io")
    public Readings saveAllReadings(@RequestBody Readings readings)
    {
        return  readserv.saveOrUpdateReadings(readings);
    }


    @CrossOrigin(origins = "http://mocker.egen.io")
    @RequestMapping(method = RequestMethod.GET,value = "{vin}",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Finds location of a vehicle in last 30 min using vin ",notes="returns latitude and longitude json of each location")
    @ApiResponses(value = {
            @ApiResponse( code=200 ,message = "OK"),@ApiResponse(code=404,message = "vehicle Not Found"),
            @ApiResponse(code=500,message = "Server Not Found")
    })
    public Iterable<Readings> findLocationByVin(@PathVariable("vin") String vin)
    {
        System.out.println("Cont"+vin);
        return readserv.findLocationByVin(vin);
    }
}
