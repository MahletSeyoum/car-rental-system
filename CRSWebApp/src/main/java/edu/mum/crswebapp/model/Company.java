package edu.mum.crswebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @NotBlank
    @Column(unique = true,nullable = false)
    private String companyName;


    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "company_branches",
            joinColumns = {@JoinColumn(name = "COMPANY_ID", referencedColumnName = "companyId")},
            inverseJoinColumns = {@JoinColumn(name = "BRANCH_ID", referencedColumnName = "branchId")}
    )
    private List<Branch> branches;

    public Company() {
    }

    public Company(Long companyId, String companyName, List<Branch> branches) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.branches = branches;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Branch> getBranchList() {
        return branches;
    }

    public void setBranchList(List<Branch> branches) {
        this.branches = branches;
    }
}
