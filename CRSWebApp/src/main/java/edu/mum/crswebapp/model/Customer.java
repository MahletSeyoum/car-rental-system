package edu.mum.crswebapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;


    @Column(nullable = false)
    @NotBlank(message = "Full name is required")
    private String fullName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DateOfBirth;

    @Column(nullable = false)
    @NotBlank(message = "Drivers license is required")
    private String driversLicenseNumber;

    @Email
    private String email;

    @Embedded
    private Address address;


    public Customer() {
    }

    public Customer(Long customerId, String fullName, LocalDate dateOfBirth, String driversLicenseNumber, String email, Address address) {
        this.customerId = customerId;
        this.fullName = fullName;
        DateOfBirth = dateOfBirth;
        this.driversLicenseNumber = driversLicenseNumber;
        this.email = email;
        this.address = address;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getDriversLicenseNumber() {
        return driversLicenseNumber;
    }

    public void setDriversLicenseNumber(String driversLicenseNumber) {
        this.driversLicenseNumber = driversLicenseNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
