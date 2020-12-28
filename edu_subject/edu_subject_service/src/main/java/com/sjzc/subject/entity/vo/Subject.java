package com.sjzc.subject.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther liez
 * @Date 11:39 2020/12/28
 */
@Data
public class Subject {

    private String id;
    private String title;
    private int level;
    private String parentId;
    private List<Subject> children = new ArrayList<>();

}
