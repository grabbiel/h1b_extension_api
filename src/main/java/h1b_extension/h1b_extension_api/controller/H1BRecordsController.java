package h1b_extension.h1b_extension_api.controller;

import h1b_extension.h1b_extension_api.bean.CompanyRecord;
import h1b_extension.h1b_extension_api.bean.StringMatch;
import h1b_extension.h1b_extension_api.service.H1BRecordsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import h1b_extension.h1b_extension_api.bean.ResponseStatus;





@RestController
@RequestMapping(value = "/h1brecords", produces = "application/json")
public class H1BRecordsController {
    @Autowired
    H1BRecordsService h1bRecordsService;

    @CrossOrigin(origins = {"chrome-extension://dfpimaaljehjdhfnaeleacollelmejnj/"}, maxAge = 2000)
    @GetMapping("/has_match")
    public ResponseEntity<ResponseStatus> companyHasMatch(
        @RequestParam(value="company") String name
    ){
        ResponseStatus status = h1bRecordsService.companyHasMatch(name);
        return new ResponseEntity<ResponseStatus>(status, HttpStatus.OK);
    }

    @CrossOrigin(origins = {"chrome-extension://dfpimaaljehjdhfnaeleacollelmejnj/"}, 
    maxAge = 2000)
    @GetMapping("/literal_match")
    public ResponseEntity<StringMatch> lookCompanyMatch(
        @RequestParam(value="company") String name
    ){
        StringMatch status = h1bRecordsService.lookCompanyMatch(name);
        return new ResponseEntity<StringMatch>(status, HttpStatus.OK);
    }


    @CrossOrigin(origins = {"chrome-extension://dfpimaaljehjdhfnaeleacollelmejnj/"}, maxAge = 1800)
    @GetMapping(value = "/record")
    public ResponseEntity<CompanyRecord> getCompanyRecord(@RequestParam(value="str_match") String name){
        CompanyRecord info = h1bRecordsService.getCompanyRecord(name);    
        return new ResponseEntity<CompanyRecord>(info, HttpStatus.OK);
    }
}
