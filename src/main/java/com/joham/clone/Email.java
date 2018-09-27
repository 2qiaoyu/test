package com.joham.clone;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author joham
 */
@Data
@AllArgsConstructor
public class Email implements Serializable {

    /**
     * 内容
     */
    private String content;
}
