package com.sjzc.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sjzc.client.EduCourseClient;
import com.sjzc.client.EduUserClient;
import com.sjzc.domain.Order;
import com.sjzc.domain.vo.UserConter;
import com.sjzc.entity.EduCourse;
import com.sjzc.entity.vo.CoursePublishVo;
import com.sjzc.mapper.EduOrderMapper;
import com.sjzc.service.EduOrderService;
import com.sjzc.utils.GetUuid;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther liez
 * @Date 16:18 2020/12/24
 */
@Service
public class EduOrderServiceImpl implements EduOrderService {

    @Autowired
    private EduUserClient userClient;
    @Autowired
    private EduCourseClient courseClient;
    @Autowired
    private EduOrderMapper orderMapper;

    @Override
    public void insertOrder(String courseId,String userId) {

        //获得课程和教师的相关信息
        R r = courseClient.getPublishCourse(courseId);
        Map<String, Object> dataMap = r.getData();
//        CoursePublishVo coursePublishVo = (CoursePublishVo)dataMap.get("data");
        //LinkHashMap转自定义实体类
        JSONObject jsonDataMap = JSONObject.parseObject(JSONObject.toJSONString(dataMap.get("data")));
        CoursePublishVo coursePublishVo = JSONObject.toJavaObject(jsonDataMap,CoursePublishVo.class);


        //获得会员的相关信息
        R userR = userClient.getUserById(userId);
        Map<String, Object> userDataMap = userR.getData();
//        UserConter user = (UserConter) userDataMap.get("data");
        //LinkHashMap转自定义实体类
        JSONObject jsonUserMap = JSONObject.parseObject(JSONObject.toJSONString(userDataMap.get("data")));
        UserConter user = JSONObject.toJavaObject(jsonUserMap,UserConter.class);

        String title = coursePublishVo.getTitle();
        String cover = coursePublishVo.getCover();
        String teacherName = coursePublishVo.getTeacherName();
        String price = coursePublishVo.getPrice();
        double priceDouble = Double.parseDouble(price);

        String id = user.getId();
        String nickname = user.getNickname();
        String mobile = user.getMobile();

        Order order = new Order();
        order.setId(GetUuid.uuid());
        order.setOrderNo(GetUuid.uuid());
        order.setCourseId(courseId);
        order.setCourseTitle(title);
        order.setCourseCover(cover);
        order.setTeacherName(teacherName);
        order.setTotalFee(priceDouble);
        order.setMemberId(id);
        order.setNickname(nickname);
        order.setMobile(mobile);
        order.setPayType(1);
        order.setStatus(0);
        order.setGmtCreate(new Date());
        order.setGmtModified(new Date());

        orderMapper.insertOrder(order);

    }
}
