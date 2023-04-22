package h1b_extension.h1b_extension_api.service;

import org.springframework.stereotype.Service;

import h1b_extension.h1b_extension_api.bean.JobPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.messaging.MessagingException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class JobPostService {
 
    @Autowired
    private PublishMessage publishMessage;
    
    @Cacheable(value = "job_post_process", key = "{#posting.position, #posting.company, #posting.description}", unless = "#result != 1")
    public int processJobPost(JobPost posting){
        try{
            publishMessage.publishJobPost(posting);
            return 1;
        }catch(MessagingException e){
            e.printStackTrace();
            return 0;
        }
    }
}
