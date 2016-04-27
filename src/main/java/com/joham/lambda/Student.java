package com.joham.lambda;

import lombok.Data;

/**
 * Created by joham on 16/3/31.
 */
@Data
public class Student {

    private Integer id;

    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
