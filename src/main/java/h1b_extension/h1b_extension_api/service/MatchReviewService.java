package h1b_extension.h1b_extension_api.service;

import h1b_extension.h1b_extension_api.bean.MatchReview;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class MatchReviewService {
    
    @Value("${AWS_TOPIC_NAME}")
    private String topicName;
    
    private final NotificationMessagingTemplate notificationMessagingTemplate;

    public void processRequest(MatchReview review){
        
        // Using SEND method
        Message<MatchReview> message = new GenericMessage<>(review);
        log.info("Method send args <<generic message>>. Using default topic");
        notificationMessagingTemplate.send(message);

        log.info("Method send args <<topic name>> and <<generic message>>");
        notificationMessagingTemplate.send(topicName, message);

        log.info("Method send args <<topic name>> and <<generic message>>. Message with headers");
        HashMap<String, Object> messageHeaders = new HashMap<>();
        messageHeaders.put("Key_send_message", "Value_send_message");
        message = new GenericMessage<>(review, messageHeaders);

    }
}
