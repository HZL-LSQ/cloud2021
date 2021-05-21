package com.hzl.springcloud.service;

public interface PaymentService {
    String paymentInfo_OK(Integer id);

    String paymentInfo_TimeOut(Integer id);

    String paymentCircuitBreaker(Integer id);

    String paymentCircuitBreaker_fallback(Integer id);
}
