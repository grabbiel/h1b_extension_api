package h1b_extension.h1b_extension_api.service;

import h1b_extension.h1b_extension_api.bean.CompanyRecord;
import h1b_extension.h1b_extension_api.bean.JobPosting;
import h1b_extension.h1b_extension_api.bean.StringMatch;
import h1b_extension.h1b_extension_api.helper.EncodedString;
import h1b_extension.h1b_extension_api.helper.StringManipulation;
import h1b_extension.h1b_extension_api.model.H1BRecord;
import h1b_extension.h1b_extension_api.model.Opening;
import h1b_extension.h1b_extension_api.model.Ranking;
import h1b_extension.h1b_extension_api.repository.H1BRecordsRepository;
import h1b_extension.h1b_extension_api.repository.OpeningRepository;
import h1b_extension.h1b_extension_api.repository.RankingRepository;
import jakarta.transaction.Transactional;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Transactional
public class H1BRecordsService {

    @Autowired
    private H1BRecordsRepository h1brecordsRepository;
    
    @Autowired
    private RankingRepository rankingRepository;

    @Autowired
    private OpeningRepository openingRepository;

    @Autowired
    private MatchReviewService matchReviewService;

    public List<H1BRecord> listAllRecords(){
        return h1brecordsRepository.findAll();
    }

    public CompanyRecord getCompanyRecord(String name){
        EncodedString instance = new EncodedString(name);
        return h1brecordsRepository.getCompanyRecord(instance.getDecodedString());
    }

    public int getCompanyId(String name){
        return h1brecordsRepository.getCompanyCode(name);
    }

    public int getCompanyRanking(int id){
        Ranking rank = rankingRepository.findById(id);
        return rank.getRanking();
    }

    public Opening getCompanyOpenings(int id){
        return openingRepository.findById(id);
    }

    public StringMatch lookCompanyMatch(String name){
        StringManipulation instance = new StringManipulation(name);
        String literal = iterateCall(instance, 0);
        if(literal==""){return new StringMatch();}
        /* maybe future schedule service: pass encoded review_match to task queue */
        /* findInsertMatchRecords(literal, instance.getDecodedString()); */
        return new StringMatch(literal);
    }
    
    @Async
    private CompletableFuture<Integer> findInsertMatchRecords(String string_match, String full_match){
        Set<String> matches = h1brecordsRepository.getCompaniesLike(string_match);
        for(String s : matches){
            matchReviewService.parseSubmission(s, full_match, 1, 0);
        }
        return CompletableFuture.completedFuture(1);
    }

    private String iterateCall(StringManipulation instance, int cutoff){
        if(instance.size() == cutoff){return "";}
        String literal = instance.getSplit(cutoff);
        if(h1brecordsRepository.existsH1BRecordByCompany(literal) || h1brecordsRepository.existsH1BRecordByCompanyStartingWith(literal+" ")){
            return literal;
        }else{
            return iterateCall(instance, cutoff+1);
        }   
    }

    public void addNewYearRecord(H1BRecord record){
        h1brecordsRepository.addNewYearRecord(record.getCompany(), record.getRequests(), record.getApprovals(), record.getYear(), record.getCountry());
        /* add caching */
    }

    public JobPosting newPosting(JobPosting posting){
        return posting;
    }

}
