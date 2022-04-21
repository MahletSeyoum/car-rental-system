package edu.mum.crswebapp.repository;

import edu.mum.crswebapp.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Integer> {
}
