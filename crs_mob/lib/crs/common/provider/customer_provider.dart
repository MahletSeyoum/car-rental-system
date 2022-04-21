import 'package:crs_mob/crs/common/model/order.dart';
import 'package:crs_mob/crs/common/service/customer_service.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../model/customer.dart';

class CustomerProvider with ChangeNotifier {
  final CustomerService _customerService = CustomerService();

  Customer? _getCustomer;

  Customer? get userCustomer => _getCustomer;

  Future getAll() async {
    _getCustomer = await _customerService.getCustomerFromAPI();
    notifyListeners();
  }

  Future syncCustomer(Map body) async {
    SharedPreferences prefs = await SharedPreferences.getInstance();
    await _customerService.loginFromAPI(body).then((value) {
      if (value.customerId != null) {
        _getCustomer = value;
        prefs.setInt("userID", value.customerId!);
      }
    });
    notifyListeners();
  }
}
