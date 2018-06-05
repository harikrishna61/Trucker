package com.harik.Service;

import com.harik.Entity.alerts;

import java.util.List;

public interface alertsService {

    public Iterable<alerts> findAllAlerts();

    public Iterable<alerts> findAlertsBYVIn(String vin);
}
