package com.harik.Repository;

import com.harik.Entity.alerts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.NamedNativeQueries;
import java.util.Optional;

public interface alertsRepository extends CrudRepository<alerts, String> {

    Iterable<alerts> findAllByVin(String vin);

    Optional<alerts> findByVin(String vin);

    @Query("select distinct a  from alerts a , Readings r where a.vin=r.vin AND a.priority='HIGH' AND " +
            "TIMESTAMPDIFF(minute,r.timestamp,NOW()) < 120 ORDER BY  r.timestamp \n")
    Iterable<alerts> findHighAlerts();
}
