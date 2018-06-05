package com.harik.Repository;

import com.harik.Entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface vehicleRepository extends CrudRepository<Vehicle,String>
{
}
