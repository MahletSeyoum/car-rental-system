package edu.mum.crswebapp.model;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    private Integer orderNumber;

    private String startDate;

    private String returnDate;

    private String orderStatus;

    @OneToOne
    @JoinColumn(name = "vehicle_fk",nullable = false)
    private Vehicle vehicle;

    @OneToOne
    @JoinColumn(name = "customer_fk",nullable = false)
    private Customer customer;

    public Order() {
    }

    public Order(Integer orderId, Integer orderNumber, String startDate, String returnDate, String orderStatus, Vehicle vehicle, Customer customer) {
        this.orderId = orderId;
        this.orderNumber = orderNumber;
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.orderStatus = orderStatus;
        this.vehicle = vehicle;
        this.customer = customer;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNumber=" + orderNumber +
                ", startDate=" + startDate +
                ", returnDate=" + returnDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", vehicle=" + vehicle +
                ", customer=" + customer +
                '}';
    }
}
