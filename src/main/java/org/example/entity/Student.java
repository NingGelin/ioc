package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * <p>学生类</p>
 *
 * @author : ninggelin
 * @date : 2022-04-11 16:21
 **/
@Data
@AllArgsConstructor
public class Student {
    private long id;
    private String name;
    private int age;
    private Address address;
    private List<Address> addresses;

    public Student(long id, String name, int age, Address address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Student() {
        System.out.println("无参构造 Student");
    }
}