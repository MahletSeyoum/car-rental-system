package edu.mum.crswebapp.service.Impl;

import edu.mum.crswebapp.model.VehicleType;
import edu.mum.crswebapp.repository.VehicleTypeRepository;
import edu.mum.crswebapp.service.VehicleTypeService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.util.List;


import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {


  private VehicleTypeRepository vehicleTypeRepository;

  VehicleTypeServiceImpl(VehicleTypeRepository vehicleTypeRepository){
      this.vehicleTypeRepository = vehicleTypeRepository;
  }

    @Override
    public VehicleType addVehicleType(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

   @Override
    public List<VehicleType> getVehicleTypes() {
    return vehicleTypeRepository.findAll(Sort.by("vehicleTypeName"));
}
@Override
    public VehicleType getVehicleTypeById(Long id){
      return vehicleTypeRepository.findById(id).orElse(null);
}
@Override
    public VehicleType updateVehicleType(Long id , VehicleType vehicleType){
    Optional<VehicleType> optionalVehicleType = vehicleTypeRepository.findById(id);
    if (optionalVehicleType.isPresent()){
        return vehicleTypeRepository.save(vehicleType);
    }
    return vehicleType;

}
@Override
    public void removeVehicleType(Long id){
      vehicleTypeRepository.deleteById(id);
}

}
