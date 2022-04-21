import 'dart:math';

import 'package:crs_mob/crs/widget/AccountWidget.dart';
import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../common/model/order.dart';
import '../widget/customeWidget/CustomTextFormField.dart';
import 'package:intl/intl.dart';

class OrderDetailPage extends StatefulWidget {
  Order? order;
  OrderDetailPage({Key? key, this.order}) : super(key: key);

  @override
  _OrderDetailPageState createState() => _OrderDetailPageState();
}

class _OrderDetailPageState extends State<OrderDetailPage> {
  final _orderFormKey = GlobalKey<FormState>();
  TextEditingController startDateController = TextEditingController();
  TextEditingController returnDateController = TextEditingController();

  @override
  void initState() {
    startDateController.text = DateFormat('yyyy-MM-dd')
        .format(DateTime.now().add(Duration(days: 1)))
        .toString();
    returnDateController.text = DateFormat('yyyy-MM-dd')
        .format(DateTime.now().add(Duration(days: 2)))
        .toString();
    super.initState();
  }

  @override
  Widget build(BuildContext context) {
    var mediaQuery = MediaQuery.of(context).size;

    return Scaffold(
      appBar: AppBar(
        title: const Text("Order Info"),
      ),
      body: SingleChildScrollView(
        child: Container(
          height: mediaQuery.height - 200,
          margin: EdgeInsets.symmetric(horizontal: 10, vertical: 5),
          child: Form(
            key: _orderFormKey,
            child: Column(
              children: [
                const SizedBox(height: 15),
                Text(
                  "Choose Order Date",
                  style: TextStyle(fontSize: 20),
                ),
                const SizedBox(height: 25),
                CustomTextFormField(
                    controller: startDateController, hintName: "Book for"),
                const SizedBox(height: 15),
                CustomTextFormField(
                    controller: returnDateController, hintName: "Return Date"),
                const SizedBox(height: 15),
                // Spacer(),
                OutlinedButton(
                  style: ElevatedButton.styleFrom(
                    minimumSize: Size(
                        mediaQuery.width - 50, 50), // <--- this line helped me
                  ),
                  child: const Text("Next"),
                  onPressed: buttonPressed,
                ),
                const SizedBox(height: 15),
              ],
            ),
          ),
        ),
      ),
    );
  }

  void buttonPressed() async {
    Random random = new Random();
    int randomNumber = random.nextInt(100);
    SharedPreferences prefs = await SharedPreferences.getInstance();
    int? orderNumber = prefs.getInt("orderNumber");
    if (orderNumber != null) {
      orderNumber = orderNumber + randomNumber;
      prefs.setInt("orderNumber", orderNumber);
    } else {
      prefs.setInt("orderNumber", 1000020);
      orderNumber = 1000020;
    }

    widget.order!.startDate = startDateController.text;
    widget.order!.returnDate = returnDateController.text;
    widget.order!.orderStatus = "Booked";
    widget.order!.orderNumber = orderNumber;

    Navigator.push(
      context,
      MaterialPageRoute(
          builder: (context) => AccountWidget(
                order: widget.order,
              )),
    );
  }
}
