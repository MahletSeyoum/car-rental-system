package edu.mum.crswebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

  @Entity
  @Table(name = "vehicletypes")
  public class VehicleType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long vehicleId;
  @Column(nullable = false)
  @NotBlank(message = "name can not be empty")
  private String Name;
  @Column(nullable = false)
  @NotBlank(message = "price can not be empty")
  private Double price;
  @Column(nullable = false)
  @NotBlank(message = "number of seats can not be empty")
  private int numberOfSeats;

  public VehicleType() {
  }

  public VehicleType(Long vehicleId, String name, Double price, int numberOfSeats) {
    this.vehicleId = vehicleId;
    Name = name;
    this.price = price;
    this.numberOfSeats = numberOfSeats;
  }

  public Long getVehicleId() {
    return vehicleId;
  }

  public String getName() {
    return Name;
  }

  public Double getPrice() {
    return price;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setVehicleId(Long vehicleId) {
    this.vehicleId = vehicleId;
  }

  public void setName(String name) {
    Name = name;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }



}
