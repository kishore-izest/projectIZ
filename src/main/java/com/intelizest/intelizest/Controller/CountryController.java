package com.intelizest.intelizest.Controller;


import com.intelizest.intelizest.DTO.ResponseDTO;
import com.intelizest.intelizest.DTO.ServiceMessageDTO.CountryResponseDTO;
import com.intelizest.intelizest.Entity.Country;
import com.intelizest.intelizest.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {


    @Autowired
    CountryService countryService;

    @GetMapping("all-country")
    public List<Country> getAllCountry(){
        List<Country> response= countryService.getAllCountryService();
        return  response;
    }


    @GetMapping("country-by-code")
    public CountryResponseDTO getCountryByCode(String code) {
        CountryResponseDTO country=countryService.getCountryByCodeService(code);
        return country;
    }

    @PostMapping("create-country")
    public ResponseEntity<ResponseDTO> CreateCountry(@RequestBody Country country){

        ResponseDTO responseDTO=new ResponseDTO();

        boolean value= countryService.createCountryService(country);
        if(value) {
            responseDTO.setMessage("Country Created success");
        }
        else{
            responseDTO.setMessage(" not Created Bad Request");
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);


    }

    @PutMapping("update-country")
    public ResponseEntity<ResponseDTO> UpdateCountry(@RequestBody Country country){

        ResponseDTO responseDTO=new ResponseDTO();
        boolean value=countryService.updateCountryService(country);
        if(value) {
            responseDTO.setMessage("Country Updated success");
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


}
