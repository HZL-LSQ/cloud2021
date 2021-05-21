package com.hzl.springcloud.controller;

import com.hzl.springcloud.entities.CommonResult;
import com.hzl.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {

        @Resource
        private RestTemplate restTemplate;

        private static final  String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

        @PostMapping("/consumer/create")
        public CommonResult<Payment> create(Payment payment){
           return restTemplate.postForObject(PAYMENT_URL+"create",payment,CommonResult.class);
        }


    @GetMapping("/consumer/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/get/"+id,CommonResult.class);
    }



}
