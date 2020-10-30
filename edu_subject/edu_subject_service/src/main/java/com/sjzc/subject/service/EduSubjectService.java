package com.sjzc.subject.service;

import com.sjzc.subject.entity.EduSubject;
import com.sjzc.subject.entity.vo.OneLevelSubject;
import com.sjzc.utils.R;

import java.util.List;

/**
 * @author liez
 * @since 2020-10-19
 */
public interface EduSubjectService{

    R getOneLevelByPage(int current, int limit);

    int insertOneLevel(String oneLevel);

    int insertTwoLevel(String oneLevel, String twoLevel);

    EduSubject getByOneLevel(String oneLevel);

    R getTwoLevelByPage(int current, int limit);

    List<OneLevelSubject> getAll();

    void deleteById(String id);

//    void updateSubject(Map<String,Object> map);
}
