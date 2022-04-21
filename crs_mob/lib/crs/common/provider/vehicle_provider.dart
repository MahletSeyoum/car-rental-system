import 'package:crs_mob/crs/common/model/vehicle.dart';
import 'package:crs_mob/crs/common/service/vehicle_service.dart';
import 'package:flutter/material.dart';

class VehicleProvider with ChangeNotifier {
  final VehicleService _vehicleService = VehicleService();

  List<Vehicle>? _getAllVehicle = [];

  List<Vehicle>? get vehicleList => _getAllVehicle;

  Future getAll() async {
    _getAllVehicle = await _vehicleService.getVehiclesFromAPI();
    // _getAllVehicle = Vehicle.listVehicle;
    notifyListeners();
  }
}
