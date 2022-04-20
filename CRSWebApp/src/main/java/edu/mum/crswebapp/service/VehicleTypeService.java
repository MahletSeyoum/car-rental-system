package edu.mum.crswebapp.service;

import edu.mum.crswebapp.model.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleTypeService {
    public abstract VehicleType addVehicleType(VehicleType vehicleType);

    public abstract List<VehicleType> getVehicleTypes();

    public abstract VehicleType getVehicleTypeById(Long id);

    public abstract VehicleType updateVehicleType(Long id ,VehicleType vehicleType);

    public abstract void removeVehicleType(Long id);




}
