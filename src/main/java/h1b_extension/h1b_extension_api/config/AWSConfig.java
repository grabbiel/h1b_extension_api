package h1b_extension.h1b_extension_api.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;



@Configuration
public class AWSConfig {
    @Value("${AWS_REGION}")
    private String awsRegion;

    @Value("${AWS_SQS_ACCESS_KEY}")
    private String awsAccessKey;

    @Value("${AWS_SQS_SECRET_KEY}")
    private String awsSecretKey;

    @Value("${AWS_SNS_ENDPOINT}")
    private String awsSnsEndpoint;

    @Value("${AWS_TOPIC_NAME_MATCHREVIEW}")
    private String awsTopicName;

    @Bean
    public AWSCredentials credentials(){
        return new BasicAWSCredentials(awsAccessKey, awsSecretKey);
    }

    @Bean AmazonSNS amazonSNS(){
        return AmazonSNSClientBuilder.standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials()))
            .withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(awsSnsEndpoint, awsRegion)
            )
            .build();
    }

    @Bean
    public NotificationMessagingTemplate notificationMessagingTemplate(){
        NotificationMessagingTemplate notificationMessagingTemplate = new NotificationMessagingTemplate(amazonSNS());
        MappingJackson2MessageConverter mappingJackson2MessageConverter = new MappingJackson2MessageConverter();
        mappingJackson2MessageConverter.setSerializedPayloadClass(String.class);
        mappingJackson2MessageConverter.getObjectMapper().registerModule(new JavaTimeModule());
        notificationMessagingTemplate.setMessageConverter(mappingJackson2MessageConverter);
        notificationMessagingTemplate.setDefaultDestinationName(awsTopicName);
        return notificationMessagingTemplate;
    }
}
