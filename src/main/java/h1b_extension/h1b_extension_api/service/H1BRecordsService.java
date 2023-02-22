package h1b_extension.h1b_extension_api.service;

import h1b_extension.h1b_extension_api.bean.CompanyRecord;
import h1b_extension.h1b_extension_api.bean.StringMatch;
import h1b_extension.h1b_extension_api.helper.EncodedString;
import h1b_extension.h1b_extension_api.helper.StringManipulation;
import h1b_extension.h1b_extension_api.repository.H1BRecordsRepository;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class H1BRecordsService {

    @Autowired
    private H1BRecordsRepository h1brecordsRepository;

    @Autowired
    private CacheMethods cacheMethods;

    //@Cacheable(value = "company_match", key = "#name")
    public StringMatch lookCompanyMatch(String name){
        StringManipulation instance = new StringManipulation(name);
        String literal = cacheMethods.iterateCall(instance, 0);
        if(literal==""){return new StringMatch();}
        else{return new StringMatch(literal);}
    }

    public CompanyRecord getCompanyRecord(String name){
        EncodedString instance = new EncodedString(name);
        return h1brecordsRepository.getCompanyRecord(instance.getDecodedString());
    }


}
