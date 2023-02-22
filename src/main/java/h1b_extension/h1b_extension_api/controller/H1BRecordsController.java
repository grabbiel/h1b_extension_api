package h1b_extension.h1b_extension_api.controller;

import h1b_extension.h1b_extension_api.bean.CompanyRecord;
import h1b_extension.h1b_extension_api.bean.StringMatch;
import h1b_extension.h1b_extension_api.service.H1BRecordsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/h1brecords", produces = "application/json")
public class H1BRecordsController {
    @Autowired
    H1BRecordsService h1bRecordsService;

    @CrossOrigin(origins = {"chrome-extension://dfpimaaljehjdhfnaeleacollelmejnj/"}, maxAge = 3600)
    @GetMapping("/matches")
    public ResponseEntity lookCompanyMatch(@RequestParam(value="str_literal") String name){
        StringMatch status = h1bRecordsService.lookCompanyMatch(name);
        return ResponseEntity.ok().body(status);
    }

    @CrossOrigin(origins = {"chrome-extension://dfpimaaljehjdhfnaeleacollelmejnj/"}, maxAge = 1800)
    @GetMapping(value = "/record")
    public ResponseEntity getCompanyRecord(@RequestParam(value="str_match") String name){
        CompanyRecord info = h1bRecordsService.getCompanyRecord(name);    
        return ResponseEntity.ok().body(info);
    }
}
