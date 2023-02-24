package h1b_extension.h1b_extension_api.service;

/* beans */
import h1b_extension.h1b_extension_api.bean.CompanyRecord;
import h1b_extension.h1b_extension_api.bean.MatchReview;
import h1b_extension.h1b_extension_api.bean.ResponseStatus;
import h1b_extension.h1b_extension_api.bean.StringMatch;

/* components */
import h1b_extension.h1b_extension_api.components.MatchReviewProducer;

/* helpers */
import h1b_extension.h1b_extension_api.helper.EncodedString;
import h1b_extension.h1b_extension_api.helper.StringManipulation;

/* repositories */
import h1b_extension.h1b_extension_api.repository.H1BRecordsRepository;

/* annotations */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class H1BRecordsService {

    @Autowired
    private H1BRecordsRepository h1brecordsRepository;

    @Autowired
    private CacheMethods cacheMethods;

    @Autowired
    private MatchReviewProducer matchReviewProducer;

    public ResponseStatus companyHasMatch(String name){
        StringManipulation instance = new StringManipulation(name);
        int status = cacheMethods.iterateStatus(instance, 0);
        return new ResponseStatus(status);
    }

    public StringMatch lookCompanyMatch(String name){
        StringManipulation instance = new StringManipulation(name);
        String literal = cacheMethods.iterateMatch(instance, 0);
        submitMatchReview(instance.encoded_string, literal);
        return new StringMatch(literal);
    }

    @Cacheable(value="company_record", key="#name")
    public CompanyRecord getCompanyRecord(String name){
        EncodedString instance = new EncodedString(name);
        String decoded = instance.getDecodedString();
        return h1brecordsRepository.getCompanyRecord(decoded);
    }

    @Async
    private void submitMatchReview(String company, String literal){/* encoded name, string literal match */
        if(literal == ""){return;}
        MatchReview review = new MatchReview(company, literal);
        log.info("Company name match review sent: {}", review);
        matchReviewProducer.send(review);
    }

}
