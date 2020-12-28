package com.sjzc.subject.controller;


import com.alibaba.fastjson.JSONObject;
import com.sjzc.subject.entity.EduSubject;
import com.sjzc.subject.entity.vo.OneLevelSubject;
import com.sjzc.subject.entity.vo.Subject;
import com.sjzc.subject.service.EduSubjectService;
import com.sjzc.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liez
 * @since 2020-10-19
 */
@RestController
@RequestMapping("/subjectService/subject")
@CrossOrigin
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    //查询第一级分类
    @GetMapping("getOneLevelByPage/{current}/{limit}")
    public R getOneLevelByPage(
            @PathVariable("current") int current,
            @PathVariable("limit") int limit){
        return subjectService.getOneLevelByPage(current,limit);

    }

    //查询第一级分类
    @GetMapping("getTwoLevelByPage/{current}/{limit}")
    public R getTwoLevelByPage(
            @PathVariable(value = "current",required = false) int current,
            @PathVariable(value = "limit",required = false) int limit){
        return subjectService.getTwoLevelByPage(current,limit);

    }

    //添加第一分类
    @PostMapping("insertOneLevel")
    public R insertOneLevel(@RequestBody JSONObject jsonObject){
        if(StringUtils.isBlank((String)jsonObject.get("oneLevel"))){
            return R.error().message("请添加一级分类名称");
        }
        String title = (String)jsonObject.get("oneLevel");
        int i = subjectService.insertOneLevel(title);
        if(i==0){
            return R.error().message("数据库中已有数据，未进行添加");
        }
        return R.oK().message("添加一条数据");

    }

    //添加二级分类
    @PostMapping("insertTwoLevel")
    public R insertTwoLevel(@RequestBody JSONObject jsonObject){
        if(StringUtils.isBlank((String)jsonObject.get("oneLevel"))){
            return R.error().message("请先选择或添加一级分类名称");
        }
        if(StringUtils.isBlank((String)jsonObject.get("twoLevel"))){
            return R.error().message("请添加二级分类名称");
        }
        String oneLevel = (String)jsonObject.get("oneLevel");
        String twoLevel = (String)jsonObject.get("twoLevel");
        int i = subjectService.insertTwoLevel(oneLevel,twoLevel);
        if(i==0){
            return R.error().message("数据库中已有数据，未进行添加");
        }
        return R.oK().message("添加一条数据");
    }

    //通过mouyi分类名称查询分类
    @PostMapping("getByOneLevel")
    public EduSubject getByoneLevel(@RequestBody String oneLevel){
        EduSubject subject = subjectService.getByOneLevel(oneLevel);
        return subject;

    }

    //获取所有的课程分类
    @GetMapping("getAll")
    public R getAll(){
        List<OneLevelSubject> list = subjectService.getAll();
        if(CollectionUtils.isEmpty(list)){
            return R.error().message("未查询到任何数据");
        }
        return R.oK().data("data",list);
    }

    //删除分类
    @PostMapping("delete/{id}")
    public R deleteById(@PathVariable("id") String id){
        try {
            subjectService.deleteById(id);
            return R.oK();
        }catch (Exception e){
            e.printStackTrace();
            return R.error().message("删除失败");
        }
    }

//    //更新分类
//    @PostMapping("update")
//    public R updateSubject(@RequestBody JSONObject jsonObject){
//        Map<String,Object> map = new HashMap<>();
//        if(StringUtils.isNotBlank((String)jsonObject.get("id"))){
//            map.put("id",jsonObject.get("id"));
//        }
//        if(StringUtils.isNotBlank((String)jsonObject.get("title"))){
//            map.put("title",jsonObject.get("title"));
//        }
//        try {
//            subjectService.updateSubject(map);
//            return R.oK();
//        }catch (Exception e){
//            e.printStackTrace();
//            return R.error();
//        }
//    }


    //使用递归查询所有分类
    @PostMapping("findAll")
    public R findAll(){
        List<Subject> subjectList = subjectService.findAll();
        return R.oK().data("data",subjectList);
    }
}

