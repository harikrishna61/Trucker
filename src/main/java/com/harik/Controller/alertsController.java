package com.harik.Controller;

import com.harik.Entity.alerts;
import com.harik.Service.alertsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/alerts")
@Api(description = "Alerts related End Points")
public class alertsController
{
    @Autowired
    private alertsService alertsService;

    @RequestMapping(value="{vin}",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find all alerts for a vehicle using vin",notes="return all alerts created for a vehicle")
    @ApiResponses(value = {
            @ApiResponse( code=200 ,message = "OK"),@ApiResponse(code=404,message = "vehicle's alert Not Found"),
            @ApiResponse(code=500,message = "Server Not Found")
    })
    @CrossOrigin(origins = "http://mocker.egen.io")
    public Iterable<alerts> findAlertsBYVIn(@PathVariable("vin") String vin)
    {
        return  alertsService.findAlertsBYVIn(vin);
    }

    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Find all high alerts in the past 2 hours ",notes="return all high alerts created in laast 2 hours ")
    @ApiResponses(value = {
            @ApiResponse( code=200 ,message = "OK"),
            @ApiResponse(code=500,message = "Server Not Found")
    })
    @CrossOrigin(origins = "http://mocker.egen.io")
    public Iterable<alerts> findALLAlerts()
    {
        return  alertsService.findAllAlerts();
    }
}
