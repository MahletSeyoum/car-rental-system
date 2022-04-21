class VehicleType {
  int? vehicleTypeId;
  String? vehicleTypeName;
  double? price;
  int? numberOfSeats;

  VehicleType(
      {this.vehicleTypeId,
      this.vehicleTypeName,
      this.price,
      this.numberOfSeats});

  int? get VehicleTypeId => vehicleTypeId;
  String? get VehicleTypeName => vehicleTypeName;
  double? get Price => price;
  int? get NumberOfSeats => numberOfSeats;

  VehicleType.map(dynamic obj) {
    vehicleTypeId = obj['vehicleTypeId'];
    vehicleTypeName = obj['vehicleTypeName'];
    price = obj['price'];
    numberOfSeats = obj['numberOfSeats'];
  }
}
