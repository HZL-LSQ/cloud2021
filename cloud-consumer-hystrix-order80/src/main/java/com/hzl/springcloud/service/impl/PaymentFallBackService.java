package com.hzl.springcloud.service.impl;

import com.hzl.springcloud.service.PaymentHistrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallBackService implements PaymentHistrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务出现问题。请稍后重试";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务出现问题。请稍后重试";
    }
}
