package edu.mum.crswebapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    @NotBlank
    @NotNull
    @Column(nullable = false)
    private String fullName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate DateOfBirth;
    @Column(nullable = false)
    private String driversLicenseNumber;
    @Email
    private String email;

}
