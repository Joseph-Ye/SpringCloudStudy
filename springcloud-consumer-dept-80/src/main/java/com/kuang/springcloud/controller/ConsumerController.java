package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    // private static final String REST_URL_PREFIX = "http://localhost:8001/springcloud/dept";
    // 通过服务名来访问，让Ribbon自己实现负载均衡
    private static final String REST_URL_PREFIX = "http://JHYE-SPRING-CLOUD/";

    @GetMapping(value = "/consumer/dept/get/{id}")
    public Dept findDept(@PathVariable Long id){
        return restTemplate.getForObject(REST_URL_PREFIX + "/find/" + id, Dept.class);
    }
}
