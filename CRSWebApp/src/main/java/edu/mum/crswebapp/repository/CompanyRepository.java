package edu.mum.crswebapp.repository;

import edu.mum.crswebapp.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
