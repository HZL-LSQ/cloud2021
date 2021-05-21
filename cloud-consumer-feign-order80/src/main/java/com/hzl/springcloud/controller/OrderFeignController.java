package com.hzl.springcloud.controller;

import com.hzl.springcloud.entities.CommonResult;
import com.hzl.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping("consumer/payment/ofeign/timeout")
    public String paymentOFeignTimeOut(){
        return  paymentFeignService.paymentOFeignTimeOut();

    }
}
