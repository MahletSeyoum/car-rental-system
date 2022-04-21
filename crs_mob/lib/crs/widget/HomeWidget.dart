import 'package:crs_mob/crs/common/model/order.dart';
import 'package:crs_mob/crs/common/model/vehicle.dart';
import 'package:crs_mob/crs/common/provider/vehicle_provider.dart';
import 'package:crs_mob/crs/page/OrderDetailPage.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

class HomeWidget extends StatefulWidget {
  const HomeWidget({Key? key}) : super(key: key);

  @override
  _HomeWidgetState createState() => _HomeWidgetState();
}

class _HomeWidgetState extends State<HomeWidget> {
  VehicleProvider? vehicleProvider;

  @override
  void initState() {
    getVehicles();
    super.initState();
  }

  void getVehicles() async {
    VehicleProvider vehicleState =
        Provider.of<VehicleProvider>(context, listen: false);
    await vehicleState.getAll();
  }

  @override
  Widget build(BuildContext context) {
    vehicleProvider = Provider.of<VehicleProvider>(context);

    return Scaffold(
      appBar: AppBar(
        title: const Text("Choose Vehicle"),
        // centerTitle: true,
      ),
      body: GridView.count(
        physics: const BouncingScrollPhysics(),
        shrinkWrap: true,
        crossAxisCount: 2,
        mainAxisSpacing: 15,
        crossAxisSpacing: 10,
        children: vehicleProvider!.vehicleList!
            .map((vehicle) => vehicleView(vehicle))
            .toList(),
      ),
    );
  }

  Widget vehicleView(Vehicle vehicle) {
    return InkResponse(
      onTap: () => gotoDetail(vehicle),
      child: Card(
        color: Colors.grey,
        child: Column(
          // mainAxisAlignment: ,
          children: [
            Image.network(vehicle.vehicleImage!, height: 135),
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
                        Container(
                          width: MediaQuery.of(context).size.width / 4,
                          child: Text(
                            vehicle.Brand! + " " + vehicle.model!,
                            maxLines: 1,
                            overflow: TextOverflow.ellipsis,
                            style: TextStyle(color: Colors.black, fontSize: 17),
                          ),
                        ),
                        Text(
                          vehicle.vehicleType!.vehicleTypeName!,
                          style: TextStyle(color: Colors.black, fontSize: 15),
                        ),
                      ],
                    ),
                    Container(
                      child: Text(
                        "${vehicle.vehicleType!.price}\$",
                        style: TextStyle(color: Colors.black),
                      ),
                    )
                  ],
                ),
              ),
            )
          ],
        ),
      ),
    );
    ;
  }

  void gotoDetail(Vehicle vehicle) {
    Order order = new Order();
    order.vehicle = vehicle;
    print("aaaaaaaaaa ${order.toString()}");
    Navigator.push(
      context,
      MaterialPageRoute(
          builder: (context) => OrderDetailPage(
                order: order,
              )),
    );
  }
}
