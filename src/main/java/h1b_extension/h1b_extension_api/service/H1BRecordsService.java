package h1b_extension.h1b_extension_api.service;

import h1b_extension.h1b_extension_api.bean.CompanyRecord;
import h1b_extension.h1b_extension_api.bean.ResponseStatus;
import h1b_extension.h1b_extension_api.bean.StringMatch;
import h1b_extension.h1b_extension_api.helper.EncodedString;
import h1b_extension.h1b_extension_api.helper.StringManipulation;
import h1b_extension.h1b_extension_api.repository.H1BRecordsRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class H1BRecordsService {

    @Autowired
    private H1BRecordsRepository h1brecordsRepository;

    @Autowired
    private CacheMethods cacheMethods;
    
    public StringMatch lookCompanyMatch(String name){
        StringManipulation instance = new StringManipulation(name);
        String literal = cacheMethods.iterateMatch(instance, 0);
        return new StringMatch(literal);
    }

    public ResponseStatus companyHasMatch(String name){
        StringManipulation instance = new StringManipulation(name);
        int status = cacheMethods.iterateStatus(instance, 0);
        return new ResponseStatus(status);
    }


    @Cacheable(value="company_record", key="#name")
    public CompanyRecord getCompanyRecord(String name){
        EncodedString instance = new EncodedString(name);
        String decoded = instance.getDecodedString();
        return h1brecordsRepository.getCompanyRecord(decoded);
    }

}
