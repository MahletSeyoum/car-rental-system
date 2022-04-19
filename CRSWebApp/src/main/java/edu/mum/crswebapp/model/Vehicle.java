package com.example.carrental.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vehicle {
    @Id
    @Column(name = "vehicle_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vehicleId;
    @Column(nullable = false, unique = true)
    private String vinNumber;
    @Column(nullable = false, unique = true)
    private String plateNumber;
    private String brand;
    private String model;
    private String yearOfManufacture;


}
