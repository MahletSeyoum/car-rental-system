package edu.mum.crswebapp.service.impl;

import edu.mum.crswebapp.model.Vehicle;
import edu.mum.crswebapp.repository.VehicleRepository;
import edu.mum.crswebapp.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl (VehicleRepository vehicleRepository){
        this.vehicleRepository=vehicleRepository;
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId).orElse(null);
    }

    @Override
    public Vehicle addVehicles(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return null;
    }

    @Override
    public void deletePublisherById(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);

    }

}
