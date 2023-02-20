package h1b_extension.h1b_extension_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import h1b_extension.h1b_extension_api.bean.ResponseStatus;
import h1b_extension.h1b_extension_api.service.OpeningService;
import jakarta.persistence.PersistenceException;

@RestController
@RequestMapping(value = "/openings")
public class OpeningController {
    @Autowired
    OpeningService openingService;

    @PatchMapping("/add-open/{id}")
    public ResponseEntity<ResponseStatus> addOpening(@PathVariable String id){
        try{
            openingService.addOpening(id);
            ResponseStatus response = new ResponseStatus(1);
            return new ResponseEntity<ResponseStatus>(response,HttpStatus.OK);
        }catch(PersistenceException e){
            return new ResponseEntity<ResponseStatus>(HttpStatus.NOT_MODIFIED);
        }
    }

    @PatchMapping("/add-open-sponsor/{id}")
    public ResponseEntity<ResponseStatus> addSponsorOpening(@PathVariable String id){
        try{
            openingService.addSponsorOpening(id);
            ResponseStatus response = new ResponseStatus(1);
            return new ResponseEntity<ResponseStatus>(response,HttpStatus.OK);
        }catch(PersistenceException e){
            return new ResponseEntity<ResponseStatus>(HttpStatus.NOT_MODIFIED);
        }
    }
}
