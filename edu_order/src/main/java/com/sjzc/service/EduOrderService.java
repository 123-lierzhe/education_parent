package com.sjzc.service;

import com.sjzc.domain.Order;

/**
 * @Auther liez
 * @Date 16:17 2020/12/24
 */
public interface EduOrderService {

    void insertOrder(String courseId,String userId);

    Order getOrderById(String orderNo);
}
