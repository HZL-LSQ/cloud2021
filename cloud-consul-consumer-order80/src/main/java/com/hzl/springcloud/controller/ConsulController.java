package com.hzl.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsulController {
    @Resource
    private RestTemplate restTemplate;

    public static final String PAYMENT_URL="http://cloud-consul-payment";

    @GetMapping("/consumer/payment/consul")
    public String consulOrder(){
        String result = restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
        return result;
    }
}
