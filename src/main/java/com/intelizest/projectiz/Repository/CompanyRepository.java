package com.intelizest.projectiz.Repository;

import com.intelizest.projectiz.Entity.Company;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;


@Transactional
@Repository
public class CompanyRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Company> getAllCompany(){
        String hqlQuery = "From Company";
        List<Company> data = entityManager.createQuery(hqlQuery).getResultList();
        return data;
    }

    public boolean addCompany(Company company){
        entityManager.persist(company);
        return true;
    }

    public Company getCompanyByCode(String code){
        String hqlQuery = "From Company as c where c.companyCode=?1";
        Company result = (Company) entityManager.createQuery(hqlQuery).setParameter(1,code).getSingleResult();
        return result;

    }


    public boolean updateCompany(Company company){

        try{
            Company updatedCompany = entityManager.find(Company.class,company.getCompanyCode());
            updatedCompany.setCompanyName(company.getCompanyName());
            updatedCompany.setAddress1(company.getAddress1());
            updatedCompany.setAddress2(company.getAddress2());
            updatedCompany.setLocation(company.getLocation());
            updatedCompany.setCountry(company.getCountry());
            updatedCompany.setGstRegNo(company.getGstRegNo());
            updatedCompany.setCreatedBy(company.getCreatedBy());
            updatedCompany.setLastModifiedBy(company.getLastModifiedBy());
            updatedCompany.setLastModifiedDate(company.getLastModifiedDate());
            entityManager.flush();
            return true;
        }catch(Exception e){
            return  false;
        }


    }

    public boolean deleteCompany(String code){
        try{
            Company selectedCompany = entityManager.find(Company.class,code);

            entityManager.remove(selectedCompany);

        }catch (Exception e){
            return false;

        }
        return true;
    }

        


}
