package h1b_extension.h1b_extension_api.service;

/* beans */
import h1b_extension.h1b_extension_api.bean.MatchReview;
import h1b_extension.h1b_extension_api.bean.NameMatches;
import h1b_extension.h1b_extension_api.bean.OutMatchReview;

/* repositories */
import h1b_extension.h1b_extension_api.repository.H1BRecordRepository;

import java.util.List;

/* annotations */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.messaging.MessagingException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class H1BRecordsService {

    @Autowired
    private H1BRecordRepository h1brecordRepository;

    @Autowired
    private PublishMessage matchReviewService;

    @Cacheable(value="match_review_process", key="#review.name", unless = "#result != 1")
    public int processMatchReviews(MatchReview review){
        try{
            List<NameMatches> nameMatches = h1brecordRepository.getNameMatches(review.getLiteral());
            submitMatchReviews(review, nameMatches);
            return 1;
        }catch(MessagingException e){
            return 0;
        }
    }
    
    @Async
    public void submitMatchReviews(MatchReview review, List<NameMatches> nameMatches) throws MessagingException{
        String size = Integer.toString(nameMatches.size());
        log.info("Number of matches found: "+size);
        for(int i = 0; i < nameMatches.size(); i++){
            NameMatches nameMatch = nameMatches.get(i);
            submitMatchReview(review, nameMatch.getName(), nameMatch.getCode());
        }
    }

    @Async
    private void submitMatchReview(MatchReview review, String match_name, int code) throws MessagingException{
        OutMatchReview outMatchReview = new OutMatchReview(review, match_name, code);
        matchReviewService.publishMatchReview(outMatchReview);
    }
}
