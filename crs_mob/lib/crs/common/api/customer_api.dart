import 'dart:convert';

import 'package:crs_mob/crs/common/config/config.dart';
import 'package:crs_mob/crs/common/model/customer.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';

class CustomerAPI {
  final customerURL = "/crs/api/v1/customer";

  Future<Map?> getCustomer() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    int? id = prefs.getInt("userID");
    try {
      return await http
          .get(Uri.parse(Config.apiUrl + customerURL + "/$id"))
          .then((http.Response response) async {
        final statusCode = response.statusCode;
        print(
            "*************************** getCustomer ${response.statusCode}***********************************");
        if (statusCode == 200) {
          var userData = json.decode(response.body);
          return userData;
        }
        return null;
      });
    } catch (error) {
      print(
          "Error on CustomerAPI in getCustomer with Error : ${error.toString()}");
      return null;
    }
  }

  Future<int> createCustomer(Map body) async {
    Map<String, String> headers = {"Content-Type": "application/json"};
    try {
      print("aaaaaaaaaaaaaaaaaaaaa ${Config.apiUrl + customerURL}");
      return await http
          .post(Uri.parse(Config.apiUrl + customerURL + "/"),
              headers: headers, body: json.encode(body))
          .then((http.Response response) async {
        final statusCode = response.statusCode;
        print(
            "*************************** createCustomer ${response.statusCode}***********************************");
        return statusCode;
      });
    } catch (error) {
      print(
          "Error on CustomerAPI in createCustomer with Error : ${error.toString()}");
    }

    return 400;
  }

  Future<Map?> login(Map body) async {
    Map<String, String> headers = {"Content-Type": "application/json"};
    try {
      return await http
          .post(Uri.parse(Config.apiUrl + customerURL + "/login"),
              headers: headers, body: json.encode(body))
          .then((http.Response response) async {
        final statusCode = response.statusCode;
        print(
            "*************************** login ${response.statusCode}***********************************");
        if (statusCode == 200) {
          var userData = json.decode(response.body);
          return userData;
        }
        return null;
      });
    } catch (error) {
      print("Error on CustomerAPI in login with Error : ${error.toString()}");
    }

    return null;
  }
}
