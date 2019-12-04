package com.intelizest.intelizest.service;


import com.intelizest.intelizest.DTO.ServiceMessageDTO.CountryResponseDTO;
import com.intelizest.intelizest.Entity.Country;
import com.intelizest.intelizest.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {


    @Autowired
    CountryRepository countryRepository;

    public List<Country> getAllCountryService(){
        List<Country> lang= countryRepository.getAllCountry();

        return lang;
    }




    public CountryResponseDTO getCountryByCodeService(String country){
        CountryResponseDTO responseDTO=countryRepository.getCountryByCode(country);
        return responseDTO;
    }



    public boolean createCountryService(Country country){
        boolean retunvalue= countryRepository.createCountry(country);
        return retunvalue;
    }




    public boolean updateCountryService(Country country){
      boolean retunvalue=countryRepository.updateCountry(country);
        return retunvalue;
    }
}
