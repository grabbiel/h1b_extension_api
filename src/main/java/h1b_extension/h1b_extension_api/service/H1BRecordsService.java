package h1b_extension.h1b_extension_api.service;

import h1b_extension.h1b_extension_api.bean.CompanyRecord;
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

    @Cacheable(value = "companyRecordCache")
    public CompanyRecord getCompanyRecord(String name){
        EncodedString instance = new EncodedString(name);
        return h1brecordsRepository.getCompanyRecord(instance.getDecodedString());
    }

    @Cacheable(value = "stringMatchCache")
    public StringMatch lookCompanyMatch(String name){
        StringManipulation instance = new StringManipulation(name);
        String literal = iterateCall(instance, 0);
        if(literal==""){return new StringMatch();}
        return new StringMatch(literal);
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

    public int getCompanyId(String name){
        return h1brecordsRepository.getCompanyCode(name);
    }
}
