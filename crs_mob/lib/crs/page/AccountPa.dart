import 'package:flutter/material.dart';

class AccountPa extends StatefulWidget {
  const AccountPa({Key? key}) : super(key: key);

  @override
  _AccountPaState createState() => _AccountPaState();
}

class _AccountPaState extends State<AccountPa> {
  @override
  Widget build(BuildContext context) {
    return Center(
      child: Text("Customer Logged In"),
    );
  }
}
