package org.example.entity;

import lombok.Data;

/**
 * <p>人</p>
 *
 * @author : ninggelin
 * @date : 2022-04-11 18:09
 **/
@Data
public class Person {
    private long id;
    private String name;
    private Car car;
}
