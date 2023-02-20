package h1b_extension.h1b_extension_api.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import h1b_extension.h1b_extension_api.repository.H1BRecordsRepository;
import h1b_extension.h1b_extension_api.repository.MatchReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;


@Service
@Transactional
public class MatchReviewService {
    @Autowired
    private MatchReviewRepository matchRepository;
    
    @Autowired
    private H1BRecordsRepository h1bRepository;

    public boolean exist_uscis(String name){
        return matchRepository.existsMatchReviewByUscis(name);
    }
    public boolean exist_alternate(String name){
        return matchRepository.existsMatchReviewByAlternatename(name);
    }
    public void insertNewRecord(String uscis_name, int job_board_code, String match_name, int h1b_records_id, int country_code){
        matchRepository.insertNewRecord(uscis_name, job_board_code, match_name, h1b_records_id, country_code);
    }
    public int parseSubmission(String uscis_name, String match_name, int job_board_code, int country_code){
        if(exist_uscis(uscis_name) && exist_alternate(match_name)){
            return 0;
        }
        int uscis_id = h1bRepository.getCompanyCode(uscis_name);
        matchRepository.insertNewRecord(uscis_name, job_board_code, match_name, uscis_id, country_code);
        return 1;
    }
}
