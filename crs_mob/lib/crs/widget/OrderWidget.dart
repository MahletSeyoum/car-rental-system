import 'package:crs_mob/crs/common/provider/order_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../common/model/order.dart';

class OrderWidget extends StatefulWidget {
  const OrderWidget({Key? key}) : super(key: key);

  @override
  _OrderWidgetState createState() => _OrderWidgetState();
}

class _OrderWidgetState extends State<OrderWidget> {
  OrderProvider? orderProvider;
  bool? isLoggedIn = false;

  @override
  void initState() {
    checkUser();
    super.initState();
  }

  Future getOrders() async {
    OrderProvider orderState =
        Provider.of<OrderProvider>(context, listen: false);
    await orderState.getAll();
  }

  Future checkUser() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    if (prefs.getInt("userID") != null) {
      await getOrders();
      setState(() {
        isLoggedIn = true;
      });
    }
    print("Customer Not Found");
  }

  int calculatePrice(String start, String end, double price) {
    var startConv = DateTime.parse(start);
    var endConv = DateTime.parse(end);
    int def = endConv.difference(startConv).inDays;

    print("calculatePricecalculatePrice ${def}");
    return (price * def).round();
  }

  @override
  Widget build(BuildContext context) {
    orderProvider = Provider.of<OrderProvider>(context);

    return Scaffold(
      appBar: AppBar(
        title: const Text("Order"),
        // centerTitle: true,
      ),
      body: Container(
        child: isLoggedIn!
            ? ListView.separated(
                physics: const BouncingScrollPhysics(),
                shrinkWrap: true,
                itemCount: orderProvider!.orderList!.length,
                itemBuilder: (BuildContext context, int index) {
                  return vehicleView(orderProvider!.orderList![index]);
                },
                separatorBuilder: (_, int index) => const SizedBox(height: 10),
              )
            : Center(
                child: Text("Not Logged In"),
              ),
      ),
    );
  }

  Widget vehicleView(Order order) {
    return InkResponse(
      onTap: () => gotoDetail(order),
      child: Card(
        color: Colors.grey,
        child: Container(
          height: 200,
          child: Column(
            // mainAxisAlignment: ,
            children: [
              Image.network(order.vehicle!.vehicleImage!, height: 120),
              Expanded(
                child: Container(
                  color: Colors.white,
                  padding: EdgeInsets.symmetric(horizontal: 5),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.spaceBetween,
                    crossAxisAlignment: CrossAxisAlignment.center,
                    children: [
                      Column(
                        crossAxisAlignment: CrossAxisAlignment.start,
                        children: [
                          Text(
                            order.vehicle!.Brand! + " " + order.vehicle!.model!,
                            style: TextStyle(color: Colors.black, fontSize: 17),
                          ),
                          Text(
                            order.vehicle!.vehicleType!.vehicleTypeName!,
                            style: TextStyle(color: Colors.black, fontSize: 15),
                          ),
                          SizedBox(
                            height: 5,
                          ),
                          Row(
                            children: [
                              Text(
                                "Reserve Date",
                                style: TextStyle(
                                    color: Colors.black, fontSize: 15),
                              ),
                              SizedBox(width: 15),
                              Text(
                                order.startDate!,
                                style: TextStyle(
                                    color: Colors.black, fontSize: 15),
                              ),
                            ],
                          ),
                          Row(
                            children: [
                              Text(
                                "Return Date  ",
                                style: TextStyle(
                                    color: Colors.black, fontSize: 15),
                              ),
                              SizedBox(width: 15),
                              Text(
                                order.returnDate!,
                                style: TextStyle(
                                    color: Colors.black, fontSize: 15),
                              ),
                            ],
                          ),
                        ],
                      ),
                      Container(
                        child: Text(
                          "${calculatePrice(order.startDate!, order.returnDate!, order.vehicle!.vehicleType!.price!).toString()}\$",
                          style: TextStyle(color: Colors.black, fontSize: 18),
                        ),
                      )
                    ],
                  ),
                ),
              )
            ],
          ),
        ),
      ),
    );
    ;
  }

  void gotoDetail(Order order) {
    print("aaaaaaaaaa ${order.toString()}");
  }
}
