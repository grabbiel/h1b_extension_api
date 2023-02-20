package h1b_extension.h1b_extension_api.controller;

import h1b_extension.h1b_extension_api.bean.MatchRecord;
import h1b_extension.h1b_extension_api.service.MatchReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/match")
public class MatchReviewController {
    @Autowired
    MatchReviewService matchReviewService;

    @PostMapping(
        value = "/new",
        consumes = "application/json",
        produces = "application/json"
    )
    public ResponseEntity<Integer> insertSubmission(@RequestBody MatchRecord record){
        /* do not add logic here */
        int answer = matchReviewService.parseSubmission(record.getUscis(), record.getMatch(), record.getJobboard(), record.getCountry());
        return new ResponseEntity<Integer>(answer, HttpStatus.OK);
    }
}
