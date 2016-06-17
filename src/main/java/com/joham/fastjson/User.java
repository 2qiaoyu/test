package com.joham.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    private int age;

    private Address address;

    public User(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
