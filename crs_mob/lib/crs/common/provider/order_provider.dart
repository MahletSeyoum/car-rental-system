import 'package:crs_mob/crs/common/model/order.dart';
import 'package:crs_mob/crs/common/model/vehicle.dart';
import 'package:crs_mob/crs/common/service/vehicle_service.dart';
import 'package:flutter/material.dart';

import '../service/order_service.dart';

class OrderProvider with ChangeNotifier {
  final OrderService _orderService = OrderService();

  List<Order>? _getAllOrders = [];

  List<Order>? get orderList => _getAllOrders;

  Future getAll() async {
    _getAllOrders = await _orderService.getOrdersFromAPI();
    notifyListeners();
  }
}
