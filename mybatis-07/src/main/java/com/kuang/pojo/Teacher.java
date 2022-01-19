package com.kuang.pojo;


import lombok.Data;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Data
public class Teacher {

    private int id;
    private String name;

    //一个老师拥有多个学生
    private List<Student> students;



}
