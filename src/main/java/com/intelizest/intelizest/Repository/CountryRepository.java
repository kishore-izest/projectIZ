package com.intelizest.intelizest.Repository;


import com.intelizest.intelizest.DTO.ServiceMessageDTO.CountryResponseDTO;
import com.intelizest.intelizest.Entity.Country;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class CountryRepository {

    @PersistenceContext
    private EntityManager entityManager;



    public List<Country> getAllCountry(){

        String hql="From Country";
        List<Country> reports=entityManager.createQuery(hql).getResultList();
        return reports;
    }


    // get by code
    public CountryResponseDTO getCountryByCode(String code){
        CountryResponseDTO responseDTO=new CountryResponseDTO();
        Query query;
        String hql="From Country as c where c.code=?1 ";
        query = entityManager.createQuery(hql).setParameter(1, code);
        boolean isExist;
        int size=query.getResultList().size();
        isExist =size>0?true:false;
        if(isExist) {

            responseDTO.setCountry((Country) query.getSingleResult());
        } else{
            responseDTO.setMessage("Code Does not Present");
        }
    return responseDTO;
    }

    public boolean createCountry(Country country){
        entityManager.persist(country);
        return true;
    }




    public boolean updateCountry(Country country){
        boolean retunvalue=true;
        Country updateCountry=entityManager.find(Country.class,country.getCode());
        updateCountry.setDescription(country.getDescription());
        entityManager.flush();
        return retunvalue;
    }

}
