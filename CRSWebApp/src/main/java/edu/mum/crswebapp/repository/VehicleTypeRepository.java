package edu.mum.crswebapp.repository;

import edu.mum.crswebapp.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType,Long> {
}
