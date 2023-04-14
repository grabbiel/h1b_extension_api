/* package h1b_extension.h1b_extension_api.components;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import h1b_extension.h1b_extension_api.bean.MatchReview;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class MatchReviewProducer {
    
    private final KafkaTemplate<String, MatchReview> template;

    private final String topic = "match_review";
    
    public void send(MatchReview review){
        log.info("Sending <MatchReview> JSON Serializer: {}", review);
        template.send(topic, review);
    }
}
 */