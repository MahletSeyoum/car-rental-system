import 'package:crs_mob/crs/common/model/vehicle.dart';
import 'package:flutter/material.dart';
import 'dart:convert';

import 'package:crs_mob/crs/common/config/config.dart';
import 'package:http/http.dart' as http;

class VehicleAPI {
  final vehicleURL = "/crs/api/v1/vehicle";

  Future<List> getAllVehicles() async {
    try {
      return http
          .get(Uri.parse(Config.apiUrl + vehicleURL + "/"))
          .then((http.Response response) {
        final statusCode = response.statusCode;
        print(
            "*************************** getAllVehicles ${response.statusCode}***********************************");
        if (statusCode == 200) {
          var userData = json.decode(response.body);
          return userData;
        }
        return [];
      });
    } catch (error) {
      print(
          "Error on VehicleAPI in createVehicle with Error : ${error.toString()}");
      return [];
    }
  }

  Future<List> getVehicle(String id) async {
    try {} catch (error) {
      print(
          "Error on VehicleAPI in createVehicle with Error : ${error.toString()}");
      return [];
    }
    return [];
  }
}
