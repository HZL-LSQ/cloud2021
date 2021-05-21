package com.hzl.springcloud.controller;

import com.hzl.springcloud.service.PaymentHistrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentInfo_TimeOutHandler")
public class OrderHistrixController {

    @Resource
    private PaymentHistrixService paymentHistrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id){
        return paymentHistrixService.paymentInfo_OK(id);
    }

    @HystrixCommand
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int age = 10/0;
        String result = paymentHistrixService.paymentInfo_TimeOut(id);
        log.info(result);
        return result;
    }
    public String paymentInfo_TimeOutHandler() {
        return "  global请求错误。请稍后重试,无奈";
    }



}
