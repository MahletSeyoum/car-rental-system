import 'package:crs_mob/crs/common/api/customer_api.dart';
import 'package:crs_mob/crs/common/model/customer.dart';
import 'package:shared_preferences/shared_preferences.dart';

class CustomerService {
  CustomerAPI customerAPI = CustomerAPI();

  Future<Customer> getCustomerFromAPI() async {
    Customer customer = Customer();
    await customerAPI.getCustomer().then((result) {
      if (result != null) {
        customer = Customer.map(result);
      }
    });
    return customer;
  }

  void sendCustomerToAPI(Map customer) async {
    await customerAPI.createCustomer(customer);
  }

  Future<Customer> loginFromAPI(Map body) async {
    Customer customer = Customer();
    await customerAPI.login(body).then((result) {
      print("loginFromAPI ------------ ${result}");
      if (result != null) {
        customer = Customer.map(result);
      }
    });
    return customer;
  }
}
