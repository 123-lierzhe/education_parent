package com.sjzc.subject.mapper;

import com.sjzc.subject.entity.EduSubject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liez
 * @since 2020-10-19
 */
@Mapper
public interface EduSubjectMapper{

    List<EduSubject> getOneLevel();

    List<EduSubject> getTwoLevel();

    int insertSubject(EduSubject eduSubject);

    EduSubject getByOneLevel(String oneLevel);

    EduSubject findById(Integer id);

    List<EduSubject> findByParentId(Integer id);

    int deleteById(Integer id);

    void deleteByIdOrPatentId(String id);

//    void updateSubject(Map<String,Object> map);
}
