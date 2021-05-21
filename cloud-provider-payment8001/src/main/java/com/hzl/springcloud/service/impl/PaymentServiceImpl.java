package com.hzl.springcloud.service.impl;

import com.hzl.springcloud.dao.PaymentDao;
import com.hzl.springcloud.entities.Payment;
import com.hzl.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;
   public int create(Payment payment){
        return paymentDao.create(payment);
    }

   public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
