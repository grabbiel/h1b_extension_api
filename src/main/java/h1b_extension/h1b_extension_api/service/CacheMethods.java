package h1b_extension.h1b_extension_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import h1b_extension.h1b_extension_api.helper.StringManipulation;
import h1b_extension.h1b_extension_api.repository.H1BRecordsRepository;

@Service
public class CacheMethods {

    @Autowired
    private H1BRecordsRepository h1brecordsRepository;

    @Cacheable(value="company_match", key="#instance")
    public String iterateCall(StringManipulation instance, int cutoff){
        if(instance.size() == cutoff){return "";}
        String literal = instance.getSplit(cutoff);
        if(h1brecordsRepository.existsH1BRecordByCompany(literal) || h1brecordsRepository.existsH1BRecordByCompanyStartingWith(literal+" ")){
            return literal;
        }else{
            return iterateCall(instance, cutoff+1);
        }   
    }
}
