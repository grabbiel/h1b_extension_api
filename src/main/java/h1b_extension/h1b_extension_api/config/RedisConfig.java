package h1b_extension.h1b_extension_api.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.cache.annotation.EnableCaching;

@Configuration
@EnableCaching
public class RedisConfig  {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer(){
        return (builder) -> builder
        .withCacheConfiguration("match_review_process", 
            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues()
        )
        .withCacheConfiguration("job_post_process",
            RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofDays(1)).disableCachingNullValues()
        );
    }

}
