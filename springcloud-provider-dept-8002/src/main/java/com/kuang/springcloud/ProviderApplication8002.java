package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //服务启动后自动注册到eureka
@EnableDiscoveryClient //服务发现
public class ProviderApplication8002 {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication8002.class, args);
    }
}
