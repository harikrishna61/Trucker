package com.harik.Repository;

import com.harik.Entity.Tires;
import org.springframework.data.repository.CrudRepository;

public interface tireRepository extends CrudRepository<Tires, String > {
}
