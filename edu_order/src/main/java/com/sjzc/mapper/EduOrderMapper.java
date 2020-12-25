package com.sjzc.mapper;

import com.sjzc.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Auther liez
 * @Date 16:18 2020/12/24
 */
@Mapper
public interface EduOrderMapper {
    void insertOrder(Order order);

    Order getOrderById(String orderNo);
}
