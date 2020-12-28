package com.sjzc.subject.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjzc.base.exceptionHandler.EduException;
import com.sjzc.base.exceptionHandler.ExceptionEnum;
//import com.sjzc.subject.client.EduTeacherClient;
import com.sjzc.subject.entity.EduSubject;
import com.sjzc.subject.entity.vo.OneLevelSubject;
import com.sjzc.subject.entity.vo.Subject;
import com.sjzc.subject.entity.vo.TwoLevelSubject;
import com.sjzc.subject.mapper.EduSubjectMapper;
import com.sjzc.subject.service.EduSubjectService;
import com.sjzc.utils.GetUuid;
import com.sjzc.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liez
 * @since 2020-10-19
 */
@Slf4j
@Service
public class EduSubjectServiceImpl implements EduSubjectService {

    @Autowired(required = false)
    private EduSubjectMapper subjectMapper;
//    @Autowired
//    private EduTeacherClient eduTeacherClient;

    @Override
    public R getOneLevelByPage(int current, int limit) {
        PageHelper.startPage(current,limit);
        List<EduSubject> subjects = subjectMapper.getOneLevel();
        if(CollectionUtils.isEmpty(subjects)){
            throw new EduException(ExceptionEnum.SUBJECTLIST_IS_NOT_FOUND);
        }
        PageInfo<EduSubject> info = new PageInfo<>(subjects);
        System.out.println(info);
        long total = info.getTotal();
        return R.oK().data("total",total).data("subjects",subjects);

    }
    @Override
    public R getTwoLevelByPage(int current, int limit) {
        PageHelper.startPage(current,limit);
        List<EduSubject> subjects = subjectMapper.getTwoLevel();
        PageInfo<EduSubject> info = new PageInfo<>(subjects);
        System.out.println(info);
        long total = info.getTotal();
        return R.oK().data("total",total).data("subjects",subjects);
    }


    //TODO 和insertTwoLevel可以进行升级改造
    @Override
    public int insertOneLevel(String oneLevel) {
        List<String> titleList = new ArrayList<>();
        List<EduSubject> subjects = subjectMapper.getOneLevel();
        for (EduSubject subject : subjects) {
            String title = subject.getTitle();
            titleList.add(title);
        }
        boolean flag = titleList.contains(oneLevel);
        if(flag==false){
               EduSubject eduSubject = new EduSubject();
               eduSubject.setId(GetUuid.uuid());
               eduSubject.setParentId("0");
               eduSubject.setTitle(oneLevel);
               eduSubject.setGmtCreate(new Date());
               eduSubject.setGmtModified(new Date());
               int result = subjectMapper.insertSubject(eduSubject);
               return result;
        }
        return 0;
    }

    @Override
    public int insertTwoLevel(String oneLevel, String twoLevel) {

        List<String> titleList = new ArrayList<>();
        List<EduSubject> subjects = subjectMapper.getTwoLevel();
        EduSubject subject1 = subjectMapper.getByOneLevel(oneLevel);
        String id = subject1.getId();
        for (EduSubject subject : subjects) {
            String title = subject.getTitle();
            titleList.add(title);
        }
        boolean flag = titleList.contains(twoLevel);
        if(flag==false){
            EduSubject eduSubject = new EduSubject();
            eduSubject.setId(GetUuid.uuid());
            eduSubject.setParentId(id);
            eduSubject.setTitle(twoLevel);
            eduSubject.setGmtCreate(new Date());
            eduSubject.setGmtModified(new Date());
            int result = subjectMapper.insertSubject(eduSubject);
            return result;
        }
        return 0;
    }

    @Override
    public EduSubject getByOneLevel(String oneLevel) {
        EduSubject subject = subjectMapper.getByOneLevel(oneLevel);


//        List<EduSubject> twoLevel = subjectMapper.getTwoLevel();
//        List<EduSubject> oneLevel1 = subjectMapper.getOneLevel();
//        List<Map<String,List<String>>> edulist = new ArrayList<>();
//        for (EduSubject eduSubject : oneLevel1) {
//            Map<String,List<String>> map = new HashMap<>();
//            Integer id = eduSubject.getId();
//            String title = eduSubject.getTitle();
//            map.put(title,null);
//            List<String> list = new ArrayList<>();
//            for (EduSubject subject1 : twoLevel) {
//                Integer parentId = subject1.getParentId();
//                String title1 = subject1.getTitle();
//                if(id.equals(parentId)){
//                    list.add(title1);
//                    map.put(title,list);
//                }
//            }
//            edulist.add(map);
//        }
//        System.out.println(edulist.toString());


        return subject;
    }

    @Override
    public List<OneLevelSubject> getAll() {
        List<EduSubject> onesubject = subjectMapper.getOneLevel();
        List<EduSubject> twoSubject = subjectMapper.getTwoLevel();

        List<OneLevelSubject> allList = new ArrayList<>();


        for (EduSubject subject : onesubject) {
            OneLevelSubject oneLevelSubject = new OneLevelSubject();
            BeanUtils.copyProperties(subject,oneLevelSubject);

            allList.add(oneLevelSubject);

            List<TwoLevelSubject> twoAllList = new ArrayList<>();

            for (EduSubject eduSubject : twoSubject) {
                if(eduSubject.getParentId().equals(subject.getId())){
                    TwoLevelSubject twoLevelSubject = new TwoLevelSubject();
                    BeanUtils.copyProperties(eduSubject,twoLevelSubject);
                    twoAllList.add(twoLevelSubject);

                }

            }
            oneLevelSubject.setChildren(twoAllList);

        }

        return allList;

    }

    @Override
    public void deleteById(String id) {
//        EduSubject eduSubject = subjectMapper.findById(id);
//        if(eduSubject.getParentId()==0){
//            List<EduSubject> subjects = subjectMapper.findByParentId(id);
//            for (EduSubject subject : subjects) {
//                subjectMapper.deleteById(subject.getId());
//            }
//        }
//        int i = subjectMapper.deleteById(id);
//        return i;
        subjectMapper.deleteByIdOrPatentId(id);

    }

//    @Override
//    public void updateSubject(Map<String,Object> map) {
//        subjectMapper.updateSubject(map);
//    }

    @Override
    public List<Subject> findAll() {
        List<Subject> subjectList = subjectMapper.getAll();

        List<Subject> subjects = new ArrayList<>();
        for (Subject subject : subjectList) {
            if("0".equals(subject.getParentId())){
                subject.setLevel(1);
                subjects.add(selectChildern(subject,subjectList));
            }

        }

        return subjects;
    }

    private Subject selectChildern(Subject subject,List<Subject> subjectList){
        subject.setChildren(new ArrayList<Subject>());

        for (Subject subject1 : subjectList) {
            if(subject1.getParentId().equals(subject.getId())){
                subject1.setLevel(subject.getLevel()+1);
                subject.getChildren().add(selectChildern(subject1,subjectList));
            }

        }
        return subject;
    }



}
