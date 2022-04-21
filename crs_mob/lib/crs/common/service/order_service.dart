import 'package:crs_mob/crs/common/api/vehicle_api.dart';
import 'package:crs_mob/crs/common/model/order.dart';
import 'package:crs_mob/crs/common/model/vehicle.dart';

import '../api/order_api.dart';

class OrderService {
  OrderAPI orderAPI = OrderAPI();

  Future<List<Order>> getOrdersFromAPI() async {
    List<Order> listOrder = [];

    await orderAPI.getAllOrders().then((List result) {
      result.forEach((data) {
        Order order = Order.map(data);
        listOrder.add(order);
      });
    });
    return listOrder;
  }
}
