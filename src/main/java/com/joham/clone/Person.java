package com.joham.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author joham
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {


    /**
     * 姓名
     */
    private String name;

    /**
     * email
     */
    private Email email;
}
