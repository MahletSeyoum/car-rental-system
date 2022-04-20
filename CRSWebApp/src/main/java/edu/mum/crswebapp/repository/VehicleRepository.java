package edu.mum.crswebapp.repository;

import edu.mum.crswebapp.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository <Vehicle,Long>{

}
