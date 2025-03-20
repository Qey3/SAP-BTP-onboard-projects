package com.example.java_tutorial.config;

import com.example.java_tutorial.interceptor.CorrelationIdInterceptor;
import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

  @Bean
  public RestTemplate restTemplate() {
    RestTemplate restTemplate = new RestTemplate();
    restTemplate.setInterceptors(Collections.singletonList(new CorrelationIdInterceptor()));
    return restTemplate;
  }
}
