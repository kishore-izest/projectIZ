package com.intelizest.projectiz.service;

import com.intelizest.projectiz.Entity.Country;
import com.intelizest.projectiz.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountryService(){
        List<Country> report = countryRepository.getAllCountry();
        return report;
    }

    public boolean addCountryService(Country country){
        boolean returnvalue = countryRepository.addCountry(country);
        return returnvalue;
    }

    public Country getCountryByCodeService(String code){
        Country result = countryRepository.getCountryByCode(code);
        return result;
    }

    public boolean updateCountry(Country country){
        return countryRepository.updateCountry(country);
    }

    public boolean deleteCountryService(String code){
        return countryRepository.deleteCountry(code);
    }

}
