package com.sjzc.controller;

import com.sjzc.domain.Order;
import com.sjzc.service.EduOrderService;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther liez
 * @Date 16:16 2020/12/24
 */
@RestController
@RequestMapping("orderService/order")
@CrossOrigin
public class EduOrderController {

    @Autowired
    private EduOrderService orderService;

    /**
     * 生成订单
     * @return
     */
    @GetMapping("insertOrder/{courseId}/{userId}")
    public R insertOrder(@PathVariable("courseId") String courseId,
                      @PathVariable("userId") String userId){
        orderService.insertOrder(courseId,userId);
        return R.oK();
    }

    /**
     * 根据订单好查询订单信息
     * @return
     */
    @GetMapping("getOrderById/{orderNo}")
    public R getOrderById(@PathVariable String orderNo){
        Order order = orderService.getOrderById(orderNo);
        return R.oK().data("data",order);
    }
}
