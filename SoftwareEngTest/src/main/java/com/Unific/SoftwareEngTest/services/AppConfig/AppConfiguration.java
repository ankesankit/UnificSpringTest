package com.Unific.SoftwareEngTest.services.AppConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate restTemplate( RestTemplateBuilder builder ) {
        return builder.build();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();

    }
}