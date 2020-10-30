package com.sjzc.entity.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther liez
 * @Date 14:48 2020/10/21
 */
@Data
public class OneLevelSubject {
    private Integer id;
    private String title;
    private List<TwoLevelSubject> children = new ArrayList<>();

}
