import 'package:crs_mob/crs/common/provider/order_provider.dart';
import 'package:crs_mob/crs/common/provider/vehicle_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'crs/common/provider/customer_provider.dart';
import 'crs/page/HomePage.dart';

void main() {
  runApp(MultiProvider(
    providers: [
      ChangeNotifierProvider.value(value: VehicleProvider()),
      ChangeNotifierProvider.value(value: OrderProvider()),
      ChangeNotifierProvider.value(value: CustomerProvider()),
    ],
    child: const MyApp(),
  ));
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'CRS App',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        primarySwatch: Colors.blueGrey,
      ),
      home: const HomePage(),
    );
  }
}
