package h1b_extension.h1b_extension_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.common.config.TopicConfig;
//import org.springframework.context.annotation.Bean;
//import org.springframework.kafka.annotation.EnableKafka;
//import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
@EnableCaching
//@EnableKafka
public class H1bExtensionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(H1bExtensionApiApplication.class, args);
	}

/*     @Bean
    public NewTopic matchReview(){
        return TopicBuilder.name("match_review")
                .partitions(2)
                .config(TopicConfig.RETENTION_MS_CONFIG, "86400000")
                .config(TopicConfig.RETENTION_BYTES_CONFIG, "50000000")
                .build();
    } */


}
