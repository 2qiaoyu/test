package com.joham.fastjson;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private String province;

    private String city;

    private String street;

    private String post;
}
