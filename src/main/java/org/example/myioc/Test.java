package org.example.myioc;

import org.example.entity.Car;

/**
 * <p></p>
 *
 * @author : ninggelin
 * @date : 2022-04-12 11:11
 **/
public class Test {
    public static void main(String[] args) {
        MyApplicationContext myApplicationContext = new MyClassPathXmlApplicationContext("myioc.xml");
        Car car = (Car) myApplicationContext.getBean("car");
        System.out.println(car);
    }
}
