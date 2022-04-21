package edu.mum.crswebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @NotBlank(message = "Full Name can not be Empty!")
    @Column(nullable = false)
    private String fullName;

    @NotBlank(message = "License Number can not be Empty!")
    @Column(nullable = false)
    private String drivingLicenseNumber;

    @NotBlank(message = "Phone Number can not Empty!")
    @Column(nullable = false)
    private String phoneNumber;

//    private LocalDate dateOfBirth;

    private String email;

    @Embedded
    private Address address;

    public Customer() {
    }

    public Customer(Integer customerId, String fullName, String drivingLicenseNumber, String phoneNumber, String email) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.phoneNumber = phoneNumber;
//        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public Customer(String fullName, String drivingLicenseNumber, String phoneNumber, String email) {
        this.fullName = fullName;
        this.drivingLicenseNumber = drivingLicenseNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public void setDrivingLicenseNumber(String drivingLicenseNumber) {
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
//
//    public void setDateOfBirth(LocalDate dateOfBirth) {
//        this.dateOfBirth = dateOfBirth;
//    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", fullName='" + fullName + '\'' +
                ", drivingLicenseNumber='" + drivingLicenseNumber + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
//                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                '}';
    }
}
