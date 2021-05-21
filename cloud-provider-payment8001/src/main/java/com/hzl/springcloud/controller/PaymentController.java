package com.hzl.springcloud.controller;

import com.hzl.springcloud.entities.CommonResult;
import com.hzl.springcloud.entities.Payment;
import com.hzl.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;

//    插入功能
    @PostMapping("/create")

    public CommonResult create(@RequestBody Payment payment){
        int count = paymentService.create(payment);
        log.info("插入结果"+count);
        if(count>0){
            return new CommonResult(200,"插入成功",count);
        }else{
            return new CommonResult(500,"插入失败",null);
        }
    }

//    查询功能
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        log.info("查询结果"+paymentById);
        if(paymentById!=null){
            return new CommonResult(200,"查询成功，serverPort"+serverPort,paymentById);
        }else{
            return new CommonResult(500,"查询失败",null);
        }
    }


    @GetMapping("/lb")
    public  String getPaymentLB(){
        return serverPort;
    }

    @GetMapping("/payment/ofeign/timeout")
    public String paymentOFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }




}
