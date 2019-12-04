package com.intelizest.projectiz.Repository;

import com.intelizest.projectiz.Entity.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class CountryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public List<Country> getAllCountry(){
        String hqlQuery = "From Country";
        List<Country> datas = entityManager.createQuery(hqlQuery).getResultList();
        return datas;
    }

    public boolean addCountry(Country country){
        entityManager.persist(country);
        return true;
    }

    public Country getCountryByCode(String code){
        String hqlQuery = "From Country as c where c.code=?1";
        Country result = (Country) entityManager.createQuery(hqlQuery).setParameter(1,code).getSingleResult();
        return result;

    }

    public boolean updateCountry(Country country){

        try{
            Country updatedCountry = entityManager.find(Country.class,country.getCode());
            updatedCountry.setDescription(country.getDescription());
            entityManager.flush();
            return true;
        }catch(Exception e){
            return  false;
        }


    }

    public boolean deleteCountry(String code){
        try{
            Country selectedCountry = entityManager.find(Country.class,code);

            entityManager.remove(selectedCountry);

        }catch (Exception e){
            return false;
        }
        return true;
    }

}
