package h1b_extension.h1b_extension_api.controller;

import h1b_extension.h1b_extension_api.bean.JobPost;
import h1b_extension.h1b_extension_api.bean.MatchReview;
import h1b_extension.h1b_extension_api.service.H1BRecordsService;
import h1b_extension.h1b_extension_api.service.JobPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/h1brecords", produces = "application/json")
public class H1BRecordsController {
    
    @Autowired
    H1BRecordsService h1bRecordsService;

    @Autowired
    JobPostService jobPostService;

    @CrossOrigin //(origins = {chromeid, "http://localhost:8080"}, maxAge = 1800)
    @PostMapping(value = "/match-review", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> processMatchReviews(
        @RequestBody MatchReview matchReview
    ){
        int response = h1bRecordsService.processMatchReviews(matchReview);
        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/job-post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> processJobPost(
        @RequestBody JobPost jobPost
    ){
        int response = jobPostService.processJobPost(jobPost);
        return new ResponseEntity<Integer>(response, HttpStatus.OK);
    }

}
