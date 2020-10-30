package com.sjzc.teacher.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sjzc.teacher.entity.EduTeacher;
import com.sjzc.teacher.mapper.EduTeacherMapper;
import com.sjzc.teacher.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sjzc.teacher.vo.TeacherQuery;
import com.sjzc.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author liez
 * @since 2020-10-09
 */
@Service
public class EduTeacherServiceImpl implements EduTeacherService {

    @Autowired
    private EduTeacherMapper teacherMapper;

    @Override
    public List<EduTeacher> findAll() {
        return teacherMapper.selectList(null);

    }

    @Override
    public int deleteTeacher(String id) {
        int i = teacherMapper.deleteById(id);
        return i;
    }

    @Override
    public R findTeacherByPage(long current, long limit) {
        Page<EduTeacher> page = new Page<>(current,limit);
        teacherMapper.selectPage(page,null);
        long total = page.getTotal();
        List<EduTeacher> teachers = page.getRecords();
        return R.oK().data("total",total).data("teachers",teachers);
    }

    @Override
    public R findTeacherByPageAndCondition(long current, long limit, TeacherQuery teacherQuery) {
        Page<EduTeacher> page = new Page<>(current,limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        if(teacherQuery != null) {
            String name = teacherQuery.getName();
            Integer level = teacherQuery.getLevel();
            String begin = teacherQuery.getBegin();
            String end = teacherQuery.getEnd();
            if (!StringUtils.isEmpty(name)) {
                wrapper.like("name", name);
            }
            if (!StringUtils.isEmpty(level)) {
                wrapper.eq("level", level);
            }
            if (!StringUtils.isEmpty(begin)) {
                wrapper.ge("gmt_create", begin);
            }
            if (!StringUtils.isEmpty(end)) {
                wrapper.le("gmt_modified", end);
            }
        }
        wrapper.orderByDesc("gmt_create");
        teacherMapper.selectPage(page,wrapper);
        long total = page.getTotal();
        List<EduTeacher> teachers = page.getRecords();
        if(CollectionUtils.isEmpty(teachers)){
            return R.oK();
        }
        return R.oK().data("total",total).data("teachers",teachers);
    }

    @Override
    public int insertTeacher(EduTeacher eduTeacher) {
        eduTeacher.setGmtCreate(new Date());
        eduTeacher.setGmtModified(new Date());
        int i = teacherMapper.insert(eduTeacher);
        return i;
    }

    @Override
    public EduTeacher getById(String id) {
        EduTeacher eduTeacher = teacherMapper.selectById(id);
        return eduTeacher;
    }

    @Override
    public int update(EduTeacher teacher) {
        teacher.setGmtModified(new Date());
        return teacherMapper.updateById(teacher);
    }
}
