import 'package:crs_mob/crs/common/model/vehicleType.dart';

class Vehicle {
  int? vehicleId;
  String? vinNumber;
  String? plateNumber;
  String? brand;
  String? model;
  String? color;
  int? quantity;
  String? yearOfManufacture;
  String? vehicleImage;
  VehicleType? vehicleType;

  Vehicle(
      {this.vehicleId,
      this.vinNumber,
      this.plateNumber,
      this.brand,
      this.model,
      this.color,
      this.quantity,
      this.yearOfManufacture,
      this.vehicleImage,
      this.vehicleType});

  int? get VehicleId => vehicleId;
  String? get VinNumber => vinNumber;
  String? get YearOfManufacture => yearOfManufacture;
  int? get Quantity => quantity;
  String? get vehicleColor => color;
  String? get vehicleModel => model;
  String? get Brand => brand;
  String? get PlateNumber => plateNumber;
  String? get VehicleImage => vehicleImage;
  VehicleType? get VehicleTypes => vehicleType;

  Vehicle.map(dynamic obj) {
    vehicleId = obj['vehicleId'];
    vinNumber = obj['vinNumber'];
    yearOfManufacture = obj['yearOfManufacture'];
    color = obj['color'];
    model = obj['model'];
    brand = obj['brand'];
    plateNumber = obj['plateNumber'];
    vehicleImage = obj['vehicleImage'];
    vehicleType = VehicleType.map(obj['vehicleType']);
  }

  static List<Vehicle> listVehicle = [
    new Vehicle(
        vehicleId: 10000001,
        vinNumber: "234CDE",
        plateNumber: "ZZY 123",
        brand: "Toyota",
        yearOfManufacture: "2001",
        color: "Blue",
        model: "Yaris",
        vehicleImage:
            "https://s7d1.scene7.com/is/image/hyundai/2022-santa-fe-hev-limited-magnetic-force-centered-browse-hero:Browse?fmt=png-alpha",
        quantity: 12),
    new Vehicle(
        vehicleId: 10000002,
        vinNumber: "23GHF",
        plateNumber: "ZZZ 123",
        brand: "Toyota",
        yearOfManufacture: "2021",
        color: "Black",
        model: "Corola",
        vehicleImage:
            "https://s7d1.scene7.com/is/image/hyundai/2022-palisade-caligraphy-moonlight-cloud-centered-browse-hero:Browse?fmt=png-alpha",
        quantity: 12),
    new Vehicle(
        vehicleId: 10000003,
        vinNumber: "23GHF",
        plateNumber: "ZZZ 123",
        brand: "Hyundai",
        yearOfManufacture: "2021",
        color: "Black",
        model: "Corola",
        vehicleImage:
            "https://s7d1.scene7.com/is/image/hyundai/2022-santa-cruz-limited-blue-stone-centered-browse-hero:Browse?fmt=png-alpha",
        quantity: 12),
    new Vehicle(
        vehicleId: 10000002,
        vinNumber: "23GHF",
        plateNumber: "ZZZ 123",
        brand: "Toyota",
        yearOfManufacture: "2021",
        color: "Black",
        model: "Corola",
        vehicleImage:
            "https://s7d1.scene7.com/is/image/hyundai/2022-santa-fe-calligraphy-20-inch-quartz-white-centered-browse-hero:Browse?fmt=png-alpha",
        quantity: 12),
    new Vehicle(
        vehicleId: 10000005,
        vinNumber: "23GHF",
        plateNumber: "ZZZ 123",
        brand: "Toyota",
        yearOfManufacture: "2021",
        color: "Black",
        model: "Corola",
        vehicleImage:
            "https://kelwaysvillage.com/wp-content/uploads/2019/03/40-Best-Review-2019-Hyundai-Usa-Images-with-2019-Hyundai-Usa.jpg",
        quantity: 12),
    new Vehicle(
        vehicleId: 10000002,
        vinNumber: "23GHF",
        plateNumber: "ZZZ 123",
        brand: "Toyota",
        yearOfManufacture: "2021",
        color: "Black",
        model: "Corola",
        vehicleImage:
            "https://s7d1.scene7.com/is/image/hyundai/2022-palisade-caligraphy-moonlight-cloud-centered-browse-hero:Browse?fmt=png-alpha",
        quantity: 12),
    new Vehicle(
        vehicleId: 10000005,
        vinNumber: "23GHF",
        plateNumber: "ZZZ 123",
        brand: "Toyota",
        yearOfManufacture: "2021",
        color: "Black",
        model: "Corola",
        vehicleImage:
            "https://s7d1.scene7.com/is/image/hyundai/2022-elantra-n-fwd-performance-blue-centered-browse-hero:Browse?fmt=png-alpha",
        quantity: 12),
  ];

  @override
  String toString() {
    return 'Vehicle{vehicleId: $vehicleId, vinNumber: $vinNumber, plateNumber: $plateNumber, brand: $brand, model: $model, color: $color, quantity: $quantity, yearOfManufacture: $yearOfManufacture, vehicleImage: $vehicleImage}';
  }
}
