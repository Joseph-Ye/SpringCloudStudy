package com.kuang.springcloud.controller;

import com.kuang.springcloud.pojo.Dept;
import com.kuang.springcloud.service.IDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 提供RESTful接口
@RestController
@RequestMapping(value = "/dept")
@Slf4j
public class DeptProviderController {

    @Autowired
    private IDeptService deptService;

    @Autowired
    private DiscoveryClient client;

    @GetMapping(value = "/list")
    List<Dept> findAll(){
        return deptService.findAll();
    }

    @GetMapping(value = "/find/{id}")
    Dept findById(@PathVariable Long id){
        return deptService.findById(id);
    }

    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

        List<ServiceInstance> instances = client.getInstances("JHYE-SPRING-CLOUD");

        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId() + "\t"
            );
        }

        return this.client;

    }
}
