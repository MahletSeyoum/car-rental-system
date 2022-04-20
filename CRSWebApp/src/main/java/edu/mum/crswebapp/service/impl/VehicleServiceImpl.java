package edu.mum.crswebapp.service.impl;

import edu.mum.crswebapp.model.Vehicle;
import edu.mum.crswebapp.repository.VehicleRepository;
import edu.mum.crswebapp.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }
}
