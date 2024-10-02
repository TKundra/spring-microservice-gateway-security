package com.learning.food_app.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate is a Spring class used for consuming REST-ful web services by performing HTTP requests
 * (GET, POST, PUT, DELETE, etc.).
 * In this case, you're creating a RestTemplate instance to perform HTTP requests.
 * */
@Configuration
public class FoodAppConfig {
    // client-side load-balanced
    @Bean
    @LoadBalanced
    public RestTemplate template() {
        return new RestTemplate();
    }
}
