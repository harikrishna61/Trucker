package com.harik.Repository;

import com.harik.Entity.Readings;
import com.harik.Entity.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface readingsRepository extends CrudRepository<Readings,String>
{
    List<Readings> findAllByVin(String vin);

    @Query("select r.latitude,r.longitude from Vehicle v , Readings r where" +
            " v.vin=r.vin AND " +
            "r.vin=:vin  AND \n" +
            "  TIMESTAMPDIFF(minute,r.timestamp,NOW()) < 31 " +
            "order by v.vin")
    Iterable<Readings> findLocationByVin(@Param("vin") String vin);
}
