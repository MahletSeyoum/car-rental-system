import 'package:crs_mob/crs/common/model/customer.dart';
import 'package:crs_mob/crs/common/service/customer_service.dart';
import 'package:crs_mob/crs/page/AccountPa.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:shared_preferences/shared_preferences.dart';

import '../common/provider/customer_provider.dart';
import '../widget/customeWidget/CustomTextFormField.dart';

class LoginPage extends StatefulWidget {
  const LoginPage({Key? key}) : super(key: key);

  @override
  _LoginPageState createState() => _LoginPageState();
}

class _LoginPageState extends State<LoginPage> {
  CustomerProvider? customerProvider;
  CustomerService customerService = CustomerService();
  final _loginFormKey = GlobalKey<FormState>();
  TextEditingController userController = TextEditingController();
  TextEditingController passwordController = TextEditingController();

  bool? isLoggedIn = false;

  @override
  void initState() {
    checkUser();
    super.initState();
  }

  Future checkUser() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    if (prefs.getInt("userID") != null) {
      setState(() {
        isLoggedIn = true;
      });
    }
    print("Customer Not Found");
  }

  @override
  Widget build(BuildContext context) {
    customerProvider = Provider.of<CustomerProvider>(context);
    var mediaQuery = MediaQuery.of(context).size;

    return Scaffold(
      body: Container(
        height: mediaQuery.height - 200,
        margin: EdgeInsets.symmetric(horizontal: 20),
        alignment: Alignment.center,
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.center,
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            isLoggedIn!
                ? AccountPa()
                : Form(
                    key: _loginFormKey,
                    child: Column(
                      crossAxisAlignment: CrossAxisAlignment.center,
                      mainAxisAlignment: MainAxisAlignment.center,
                      children: [
                        const SizedBox(height: 15),
                        Text(
                          "Login",
                          style: TextStyle(fontSize: 25),
                        ),
                        const SizedBox(height: 25),
                        CustomTextFormField(
                            controller: userController, hintName: "Username"),
                        const SizedBox(height: 15),
                        TextFormField(
                          controller: passwordController,
                          obscureText: true,
                          decoration: InputDecoration(
                            hintText: "Password",
                            border: OutlineInputBorder(
                              borderRadius: BorderRadius.circular(10.0),
                            ),
                          ),
                        ),
                        const SizedBox(height: 15),
                        // Spacer(),
                        OutlinedButton(
                          style: ElevatedButton.styleFrom(
                            minimumSize: Size(mediaQuery.width - 50, 50),
                          ),
                          child: const Text("Login"),
                          onPressed: buttonPressed,
                        ),
                        const SizedBox(height: 15),
                        // Spacer(),
                        OutlinedButton(
                          style: ElevatedButton.styleFrom(
                            minimumSize: Size(mediaQuery.width - 50, 50),
                          ),
                          child: const Text("Register"),
                          onPressed: buttonRegisterPressed,
                        ),
                        const SizedBox(height: 15),
                      ],
                    ),
                  ),
            SizedBox(height: 10),
            isLoggedIn!
                ? OutlinedButton(
                    style: ElevatedButton.styleFrom(
                      minimumSize: Size(mediaQuery.width - 50, 50),
                    ),
                    child: const Text("Log Out"),
                    onPressed: buttonPressedLogOut,
                  )
                : SizedBox(),
          ],
        ),
      ),
    );
  }

  void buttonPressed() async {
    Map cust = {
      "email": userController.text,
    };
    await customerProvider!.syncCustomer(cust);

    if (customerProvider!.userCustomer!.customerId != null) {
      setState(() {
        isLoggedIn = true;
      });
    }
  }

  void buttonRegisterPressed() async {}

  void buttonPressedLogOut() async {
    SharedPreferences prefs = await SharedPreferences.getInstance();

    prefs.remove("userID");
    setState(() {
      isLoggedIn = false;
    });
  }
}
