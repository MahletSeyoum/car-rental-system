import 'package:crs_mob/crs/common/api/customer_api.dart';
import 'package:crs_mob/crs/common/model/customer.dart';
import 'package:crs_mob/crs/common/service/order_service.dart';
import 'package:flutter/material.dart';
import 'package:intl/intl.dart';
import 'package:provider/provider.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../common/api/order_api.dart';
import '../common/model/order.dart';
import '../common/provider/customer_provider.dart';
import '../common/service/customer_service.dart';
import 'customeWidget/CustomTextFormField.dart';

class AccountWidget extends StatefulWidget {
  Order? order;
  AccountWidget({Key? key, this.order}) : super(key: key);

  @override
  _AccountWidgetState createState() => _AccountWidgetState();
}

class _AccountWidgetState extends State<AccountWidget> {
  final _accountFormKey = GlobalKey<FormState>();
  TextEditingController fullNameController = TextEditingController();
  TextEditingController driverLicController = TextEditingController();
  TextEditingController phoneNumberController = TextEditingController();
  TextEditingController dateOfBirthController = TextEditingController();
  TextEditingController emailController = TextEditingController();

  bool isSuccess = false;

  @override
  void initState() {
    checkUser();
    dateOfBirthController.text =
        DateFormat('yyyy-MM-dd').format(DateTime.utc(2004)).toString();
    super.initState();
  }

  Future checkUser() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    if (prefs.getInt("userID") != null) {
      await getCustomer();
    }
    print("Customer Not Found");
  }

  Future getCustomer() async {
    CustomerProvider customerState =
        Provider.of<CustomerProvider>(context, listen: false);
    await customerState.getAll();

    if (customerState.userCustomer != null) {
      setState(() {
        fullNameController.text = customerState.userCustomer!.fullName!;
        driverLicController.text =
            customerState.userCustomer!.drivingLicenseNumber!;
        phoneNumberController.text = customerState.userCustomer!.phoneNumber!;
        emailController.text = customerState.userCustomer!.email!;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    var mediaQuery = MediaQuery.of(context).size;

    return Scaffold(
      appBar: AppBar(
        title: Text(
          "Account",
        ),
      ),
      body: SingleChildScrollView(
        child: Container(
          height: mediaQuery.height - 200,
          margin: EdgeInsets.symmetric(horizontal: 10, vertical: 5),
          child: Form(
            key: _accountFormKey,
            child: Column(
              children: [
                const SizedBox(height: 15),
                Text(
                  "Account Information",
                  style: TextStyle(fontSize: 20),
                ),
                const SizedBox(height: 25),
                CustomTextFormField(
                    controller: fullNameController, hintName: "Full Name"),
                const SizedBox(height: 15),
                CustomTextFormField(
                    controller: driverLicController,
                    hintName: "Driving License Number"),
                const SizedBox(height: 15),
                CustomTextFormField(
                    controller: phoneNumberController,
                    hintName: "Phone Number"),
                const SizedBox(height: 15),
                CustomTextFormField(
                    controller: dateOfBirthController,
                    hintName: "Date of Birth"),
                const SizedBox(height: 15),
                CustomTextFormField(
                    controller: emailController, hintName: "Email"),
                const SizedBox(height: 15),
                Spacer(),
                OutlinedButton(
                  style: ElevatedButton.styleFrom(
                    minimumSize: Size(
                        mediaQuery.width - 50, 50), // <--- this line helped me
                  ),
                  child: const Text("Order"),
                  onPressed: buttonPressed,
                ),
                const SizedBox(height: 15),
                isSuccess
                    ? const Text(
                        "Successfully Reserved!!",
                        style: TextStyle(color: Colors.green),
                      )
                    : const SizedBox()
              ],
            ),
          ),
        ),
      ),
    );
  }

  void buttonPressed() async {
    Map order = {
      "startDate": widget.order!.startDate,
      "returnDate": widget.order!.returnDate,
      "orderStatus": "Booked",
      "orderNumber": widget.order!.orderNumber,
      "vehicle": {
        "vehicleId": widget.order!.vehicle!.vehicleId,
        "vinNumber": widget.order!.vehicle!.vinNumber,
        "vehicleImage": widget.order!.vehicle!.vehicleImage,
        "plateNumber": widget.order!.vehicle!.plateNumber,
        "brand": widget.order!.vehicle!.brand,
        "model": widget.order!.vehicle!.model,
        "color": widget.order!.vehicle!.color,
        "quantity": widget.order!.vehicle!.quantity,
        "yearOfManufacture": widget.order!.vehicle!.yearOfManufacture,
        "vehicleType": {
          "vehicleTypeId": widget.order!.vehicle!.vehicleType!.vehicleTypeId,
          "vehicleTypeName":
              widget.order!.vehicle!.vehicleType!.vehicleTypeName,
          "price": widget.order!.vehicle!.vehicleType!.price,
          "numberOfSeats": widget.order!.vehicle!.vehicleType!.numberOfSeats
        }
      },
      "customer": {
        "fullName": fullNameController.text,
        "drivingLicenseNumber": driverLicController.text,
        "phoneNumber": phoneNumberController.text,
        "email": emailController.text,
        "address": {
          "state": "IOWA",
          "city": "Fairfield",
          "street": "1000 4th",
          "zipCode": "52257"
        }
      }
    };

    print("fullNameControllerfullNameController  ${order}");

    OrderService orderService = OrderService();
    OrderAPI orderAPI = OrderAPI();

    int statusCode = await orderAPI.createOrder(order);
    if (statusCode == 200) {
      setState(() {
        isSuccess = true;
        Future.delayed(Duration(seconds: 2), () {
          Navigator.pop(context);
          Navigator.pop(context);
        });
      });
    }
    // customerService.sendCustomerToAPI(cu);
    // }
  }
}
