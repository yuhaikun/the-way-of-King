package com.kuang.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private int id;
    private String name;

    //学生需要关联一个老师！
    private Teacher teacher;


}
