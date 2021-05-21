package com.hzl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    @Resource
    private RestTemplate restTemplate;

    public static final  String PAYMENT_URL = "http://cloud-provider-payment";

    @GetMapping("/consumer/payment/zk")
    public String orderZk(){
        String result = restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
        return result;
    }
}
