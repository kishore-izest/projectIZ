package com.intelizest.projectiz.service;
import com.intelizest.projectiz.Entity.Company;
import com.intelizest.projectiz.Repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getAllCompanyService(){
        List<Company> report = companyRepository.getAllCompany();
        return report;
    }

    public boolean addCompanyService(Company company){
        boolean returnvalue = companyRepository.addCompany(company);
        return returnvalue;
    }

    public Company getCompanyByCodeService(String company_code){
        Company result = companyRepository.getCompanyByCode(company_code);
        return result;
    }

    public boolean updateCompany(Company company){
        return companyRepository.updateCompany(company);
    }

    public boolean deleteCompanyService(String code){
        return companyRepository.deleteCompany(code);
    }

}
