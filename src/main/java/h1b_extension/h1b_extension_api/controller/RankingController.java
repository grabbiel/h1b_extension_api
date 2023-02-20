package h1b_extension.h1b_extension_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import h1b_extension.h1b_extension_api.bean.ResponseStatus;
import h1b_extension.h1b_extension_api.service.RankingService;
import jakarta.persistence.PersistenceException;

@RestController
@RequestMapping(value="/ranking")
public class RankingController {
    @Autowired
    RankingService rankingService;

    @PostMapping(value = "/update")
    public ResponseEntity<ResponseStatus> updateRankings(@RequestParam(value = "year") String year){
        try{
            rankingService.updateRankings(year);
            ResponseStatus response = new ResponseStatus(1);
            return new ResponseEntity<ResponseStatus>(response,HttpStatus.OK);
        }catch(PersistenceException e){
            return new ResponseEntity<ResponseStatus>(HttpStatus.NOT_MODIFIED);
        }
    }
}
