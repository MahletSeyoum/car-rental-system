import 'dart:convert';

import 'package:crs_mob/crs/common/config/config.dart';
import 'package:http/http.dart' as http;
import 'package:shared_preferences/shared_preferences.dart';

class OrderAPI {
  final orderURL = "/crs/api/v1/order";

  Future<List> getAllOrders() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    int? id = prefs.getInt("userID");
    try {
      return http
          .get(Uri.parse(Config.apiUrl + orderURL + "/$id"))
          .then((http.Response response) {
        final statusCode = response.statusCode;
        print(
            "*************************** getAllOrders ${response.statusCode}***********************************");
        if (statusCode == 200) {
          var userData = json.decode(response.body);
          return userData;
        }
        return [];
      });
    } catch (error) {
      print(
          "Error on OrderAPI in getAllOrders with Error : ${error.toString()}");
      return [];
    }
    return [];
  }

  Future<int> createOrder(Map body) async {
    Map<String, String> headers = {"Content-Type": "application/json"};
    try {
      return await http
          .post(Uri.parse(Config.apiUrl + orderURL + "/createOrder"),
              headers: headers, body: json.encode(body))
          .then((http.Response response) async {
        final statusCode = response.statusCode;
        print(
            "*************************** createOrder ${response.statusCode}***********************************");
        return statusCode;
      });
    } catch (error) {
      print(
          "Error on OrderAPI in createOrder with Error : ${error.toString()}");
    }

    return 400;
  }
}
