package edu.mum.crswebapp.service;

import edu.mum.crswebapp.model.Vehicle;

import java.util.List;

public interface VehicleService {

    public abstract List<Vehicle> getAllVehicle();
    public abstract List<Vehicle> getAllVehicles();

    public abstract Vehicle getVehicleById(Long vehicleId);

    public  abstract Vehicle addVehicles(Vehicle vehicle);

    public abstract Vehicle updateVehicle(Vehicle vehicle);

    public abstract void deletePublisherById(Long publisherId);

}
