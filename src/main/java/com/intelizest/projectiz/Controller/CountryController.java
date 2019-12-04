package com.intelizest.projectiz.Controller;
import com.intelizest.projectiz.DTO.CountryDTO;
import com.intelizest.projectiz.Entity.Country;
import com.intelizest.projectiz.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    CountryService countryService;


    @GetMapping("get-all-country")
    public ResponseEntity<List<Country>> getAllCountry(){
        List<Country> report = countryService.getAllCountryService();
        return new ResponseEntity<List<Country>>(report, HttpStatus.OK);
    }

    @PostMapping("add-new-country")
    public ResponseEntity<CountryDTO> addCountry(@RequestBody Country country){
        CountryDTO countryDTO= new CountryDTO();
        boolean value=countryService.addCountryService(country);
        if(value){
            countryDTO.setMessage("Inserted the data into table");
        }else{
            countryDTO.setMessage("Couldn't insert data into the table");
            return new ResponseEntity<>(countryDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(countryDTO,HttpStatus.OK);
    }

    @GetMapping("get-country-by-code")
    public ResponseEntity<Country> getCountryByCode(@RequestParam("countryCode") String code){
        try{
            Country search_result = countryService.getCountryByCodeService(code);
            return new ResponseEntity<Country>(search_result,HttpStatus.OK);

        }catch(Exception e)
        {
            return null;
        }
    }



    @PutMapping("update-country")
    public ResponseEntity<CountryDTO> updateCountry(@RequestBody Country country){
        boolean updationSuccessful = countryService.updateCountry(country);
        CountryDTO countryDTO= new CountryDTO();
        if(updationSuccessful){
            countryDTO.setMessage("Updated the data ");
        }else{
            countryDTO.setMessage("Couldn't update data ");
            return new ResponseEntity<>(countryDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(countryDTO,HttpStatus.OK);
        }

        @DeleteMapping("delete-country")
    public ResponseEntity<CountryDTO> deleteCountry(@RequestParam String code){

        boolean deletionSuccessful = countryService.deleteCountryService(code);
        CountryDTO countryDTO = new CountryDTO();

        if(deletionSuccessful)
            countryDTO.setMessage("Deleted the record");
        else{
            countryDTO.setMessage("Couldn't delete the record");
            return  new ResponseEntity<>(countryDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(countryDTO,HttpStatus.OK);
    }
    }

