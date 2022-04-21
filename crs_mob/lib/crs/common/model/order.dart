import 'package:crs_mob/crs/common/model/vehicle.dart';
import 'package:crs_mob/crs/common/model/vehicleType.dart';

import 'customer.dart';

class Order {
  int? orderId;
  int? orderNumber;
  String? startDate;
  String? returnDate;
  String? orderStatus;
  Vehicle? vehicle;
  Customer? customer;

  Order(
      {this.orderId,
      this.orderNumber,
      this.startDate,
      this.returnDate,
      this.orderStatus,
      this.vehicle,
      this.customer});

  int? get OrderId => orderId;
  int? get OrderNumber => orderNumber;
  String? get StartDate => startDate;
  String? get ReturnDate => returnDate;
  String? get OrderStatus => orderStatus;
  Vehicle? get selectedVehicle => vehicle;
  Customer? get addedCustomer => customer;

  Order.map(dynamic obj) {
    orderId = obj['orderId'];
    orderNumber = obj['orderNumber'];
    startDate = obj['startDate'];
    returnDate = obj['returnDate'];
    orderStatus = obj['orderStatus'];
    vehicle = Vehicle.map(obj['vehicle']);
    customer = Customer.map(obj['customer']);
  }

  @override
  String toString() {
    return 'Order{orderId: $orderId, orderNumber: $orderNumber, startDate: $startDate, returnDate: $returnDate, orderStatus: $orderStatus, vehicle: $vehicle, customer: $customer}';
  }
}
