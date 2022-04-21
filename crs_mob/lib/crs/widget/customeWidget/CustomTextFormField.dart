import 'package:flutter/material.dart';

class CustomTextFormField extends StatelessWidget {
  String? hintName;
  TextEditingController? controller;
  CustomTextFormField({Key? key, this.hintName, this.controller})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return TextFormField(
      controller: controller,
      decoration: InputDecoration(
        hintText: hintName,
        border: OutlineInputBorder(
          borderRadius: BorderRadius.circular(10.0),
        ),
      ),
    );
  }
}
