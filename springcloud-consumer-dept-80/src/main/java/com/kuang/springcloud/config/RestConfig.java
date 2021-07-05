package com.kuang.springcloud.config;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfig {

    // 配置负载均衡实现的RestTemplate
    @Bean
    @LoadBalanced  // Ribbon
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
