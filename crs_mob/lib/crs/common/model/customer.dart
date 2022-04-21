class Customer {
  int? customerId;
  String? fullName;
  String? drivingLicenseNumber;
  String? phoneNumber;
  String? dateOfBirth;
  String? email;

  Customer({
    this.customerId,
    this.fullName,
    this.drivingLicenseNumber,
    this.phoneNumber,
    this.dateOfBirth,
    this.email,
  });

  int? get Id => customerId;
  String? get FullName => fullName;
  String? get DrivingLicenseNumber => drivingLicenseNumber;
  String? get PhoneNumber => phoneNumber;
  String? get DateOfBirth => dateOfBirth;
  String? get Email => email;

  Customer.map(dynamic obj) {
    customerId = obj['customerId'];
    fullName = obj['fullName'];
    drivingLicenseNumber = obj['drivingLicenseNumber'];
    phoneNumber = obj['phoneNumber'];
    dateOfBirth = obj['dateOfBirth'];
    email = obj['email'];
  }

  @override
  String toString() {
    return 'Customer{customerId: $customerId, fullName: $fullName, drivingLicenseNumber: $drivingLicenseNumber, phoneNumber: $phoneNumber, dateOfBirth: $dateOfBirth, email: $email}';
  }
}
