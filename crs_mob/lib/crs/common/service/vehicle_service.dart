import 'package:crs_mob/crs/common/api/vehicle_api.dart';
import 'package:crs_mob/crs/common/model/vehicle.dart';

class VehicleService {
  VehicleAPI vehicleAPI = VehicleAPI();

  Future<List<Vehicle>> getVehiclesFromAPI() async {
    List<Vehicle> listVehicle = [];

    await vehicleAPI.getAllVehicles().then((List result) {
      result.forEach((data) {
        Vehicle vehicle = Vehicle.map(data);
        listVehicle.add(vehicle);
      });
    });
    return listVehicle;
  }
}
