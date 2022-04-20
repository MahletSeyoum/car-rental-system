package edu.mum.crswebapp.service.impl;

import edu.mum.crswebapp.repository.CompanyRepository;
import edu.mum.crswebapp.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    CompanyServiceImpl(CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }
}
