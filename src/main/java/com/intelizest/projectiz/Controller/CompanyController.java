package com.intelizest.projectiz.Controller;
import com.intelizest.projectiz.DTO.CompanyDTO;
import com.intelizest.projectiz.Entity.Company;
import com.intelizest.projectiz.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;


    @GetMapping("get-all-company")
    public ResponseEntity<List<Company>> getAllCompany(){
        List<Company> report = companyService.getAllCompanyService();
        return new ResponseEntity<List<Company>>(report, HttpStatus.OK);
    }

    @PostMapping("add-new-company")
    public ResponseEntity<CompanyDTO> addCompany(@RequestBody Company company){
        CompanyDTO companyDTO= new CompanyDTO();
        boolean value=companyService.addCompanyService(company);
        if(value){
            companyDTO.setErrorMessage("Inserted the data into table");
            
        }else{
            companyDTO.setErrorMessage("Couldn't insert data into the table");
            return new ResponseEntity<>(companyDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(companyDTO,HttpStatus.OK);
    }

    @GetMapping("get-company-by-code")
    public ResponseEntity<Company> getCompanyByCode(@RequestParam("companyCode") String company_code){
        try{
            Company search_result = companyService.getCompanyByCodeService(company_code);
            return new ResponseEntity<Company>(search_result,HttpStatus.OK);

        }catch(Exception e)
        {
            return null;
        }
    }



    @PutMapping("update-company")
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody Company company){
        boolean updationSuccessful = companyService.updateCompany(company);
        CompanyDTO companyDTO= new CompanyDTO();
        if(updationSuccessful){
            companyDTO.setErrorMessage("Updated the data ");
        }else{
            companyDTO.setErrorMessage("Couldn't update data ");
            return new ResponseEntity<>(companyDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(companyDTO,HttpStatus.OK);
        }

        @DeleteMapping("delete-company")
    public ResponseEntity<CompanyDTO> deleteCompany(@RequestParam String code){

        boolean deletionSuccessful = companyService.deleteCompanyService(code);
        CompanyDTO companyDTO = new CompanyDTO();

        if(deletionSuccessful)
            companyDTO.setErrorMessage("Deleted the record");
        else{
            companyDTO.setErrorMessage("Couldn't delete the record");
            return  new ResponseEntity<>(companyDTO,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(companyDTO,HttpStatus.OK);
    }
    }

