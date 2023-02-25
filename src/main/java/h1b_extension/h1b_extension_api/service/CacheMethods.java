package h1b_extension.h1b_extension_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import h1b_extension.h1b_extension_api.helper.StringManipulation;
import h1b_extension.h1b_extension_api.repository.H1BRecordRepository;

@Service
public class CacheMethods {

    @Autowired
    H1BRecordRepository h1brecordRepository;

    @Cacheable(value="literal_match", key="#instance.encoded_string")
    public String iterateMatch(StringManipulation instance, int cutoff){
        if(instance.size() == cutoff){return "";}
        String literal = instance.getSplit(cutoff);
        if(h1brecordRepository.existsH1BRecordByCompany(literal) || h1brecordRepository.existsH1BRecordByCompanyStartingWith(literal+" ")){
            return literal;
        }else{
            return iterateMatch(instance, cutoff+1);
        }   
    }

    @Cacheable(value="match_status", key="{#instance.encoded_string, #instance.decoded_string}")
    public int iterateStatus(StringManipulation instance, int cutoff){
        if(instance.size() == cutoff){return 0;}
        String literal = instance.getSplit(cutoff);
        if(h1brecordRepository.existsH1BRecordByCompany(literal) || h1brecordRepository.existsH1BRecordByCompanyStartingWith(literal+" ")){
            return 1;
        }else{
            return iterateStatus(instance, cutoff+1);
        }
    }
}
