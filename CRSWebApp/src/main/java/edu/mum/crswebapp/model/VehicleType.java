package edu.mum.crswebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
  @Table(name = "vehicletypes")
  public class VehicleType {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long vehicleTypeId;
  @Column(nullable = false)
  @NotBlank(message = "name can not be empty")
  private String vehicleTypeName;
  @Column(nullable = false)
  @NotNull(message = "price can not be empty")
  private Double price;
  @Column(nullable = false)
  @NotNull(message = "number of seats can not be empty")
  private int numberOfSeats;

  public VehicleType() {
  }

  public VehicleType(Long vehicleTypeId, String vehicleTypeName, Double price, int numberOfSeats) {
    this.vehicleTypeId = vehicleTypeId;
    this.vehicleTypeName = vehicleTypeName;
    this.price = price;
    this.numberOfSeats = numberOfSeats;
  }

  public Long getVehicleTypeId() {
    return vehicleTypeId;
  }

  public String getVehicleTypeName() {
    return vehicleTypeName;
  }

  public Double getPrice() {
    return price;
  }

  public int getNumberOfSeats() {
    return numberOfSeats;
  }

  public void setVehicleTypeId(Long vehicleTypeId) {
    this.vehicleTypeId = vehicleTypeId;
  }

  public void setVehicleTypeName(String vehicleTypeName) {
    this.vehicleTypeName = vehicleTypeName;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public void setNumberOfSeats(int numberOfSeats) {
    this.numberOfSeats = numberOfSeats;
  }

  @Override
  public String toString() {
    return "VehicleType{" +
            "vehicleTypeId=" + vehicleTypeId +
            ", vehicleTypeName='" + vehicleTypeName + '\'' +
            ", price=" + price +
            ", numberOfSeats=" + numberOfSeats +
            '}';
  }
}
