package edu.mum.crswebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Vehicles")
public class Vehicle {
    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "vinNumber can not be empty")
    private String vinNumber;
    private String vehicleImage;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "plateNumber can not be empty")
    private String plateNumber;
    @Column(nullable = false)
    @NotBlank(message = "brand can not be empty")
    private String brand;
    @Column(nullable = false)
    @NotBlank(message = "model can not be empty")
    private String model;
    @Column(nullable = false)
    @NotBlank(message = "color can not be empty")
    private String color;
//    @Column(nullable = false)
//    @NotBlank(message = "quantity can not be empty")
    private Integer quantity;
    @Column(nullable = false)
    @NotBlank(message = "year of Manufacture can not be empty")
    private String yearOfManufacture;

    @OneToOne
    @JoinColumn(name = "vehicleType_fk", nullable = false)
    private VehicleType vehicleType;

    public Vehicle() {
    }

    public Vehicle(Long vehicleId, String vinNumber, String vehicleImage, String plateNumber, String brand, String model, String color, Integer quantity, String yearOfManufacture) {
        this.vehicleId = vehicleId;
        this.vinNumber = vinNumber;
        this.vehicleImage = vehicleImage;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.quantity = quantity;
        this.yearOfManufacture = yearOfManufacture;
    }

    public Vehicle(Long vehicleId, String vinNumber, String vehicleImage, String plateNumber, String brand, String model, String color, Integer quantity, String yearOfManufacture, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.vinNumber = vinNumber;
        this.vehicleImage = vehicleImage;
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.quantity = quantity;
        this.yearOfManufacture = yearOfManufacture;
        this.vehicleType = vehicleType;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getVehicleImage() {
        return vehicleImage;
    }

    public void setVehicleImage(String vehicleImage) {
        this.vehicleImage = vehicleImage;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
