package edu.mum.crswebapp.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer branchId;

    @NotBlank(message = "Branch Name must not be Empty!")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Phone Number must not be Empty!")
    @Column(nullable = false,unique = true)
    private String phoneNumber;

    public Branch() {
    }

    public Branch(Integer branchId, String name, String phoneNumber) {
        this.branchId = branchId;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
}
