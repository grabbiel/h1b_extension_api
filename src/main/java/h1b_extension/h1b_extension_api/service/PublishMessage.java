package h1b_extension.h1b_extension_api.service;

import h1b_extension.h1b_extension_api.bean.JobPost;
import h1b_extension.h1b_extension_api.bean.OutMatchReview;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class PublishMessage {
    
    @Value("${AWS_TOPIC_NAME_MATCHREVIEW}")
    private String topicReview;
    
    @Value("${AWS_TOPIC_NAME_JOBPOST}")
    private String topicPost;
    
    private final NotificationMessagingTemplate notificationMessagingTemplate;

    @Async
    public void publishMatchReview(OutMatchReview review) throws MessagingException{
            
        log.info("Company name match review sent: {}", review);
        Message<OutMatchReview> message = new GenericMessage<>(review);
        notificationMessagingTemplate.send(topicReview, message);

    }

    @Async
    public void publishJobPost(JobPost posting) throws MessagingException{
        
        log.info("Job Posting sent: {}", posting);
        Message<JobPost> message = new GenericMessage<>(posting);
        notificationMessagingTemplate.send(topicPost, message);
    }

}
