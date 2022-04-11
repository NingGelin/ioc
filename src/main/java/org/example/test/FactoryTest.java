package org.example.test;

import org.example.entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>工厂方法测试</p>
 *
 * @author : ninggelin
 * @date : 2022-04-11 17:55
 **/
public class FactoryTest {
    public static void main(String[] args) {
        staticCarFactory();
        instanceCarFactory();
    }

    /**
     * ioc 静态工厂方法
     */
    private static void staticCarFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-static-factory.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
    }

    /**
     * ioc 实例工厂方法
     */
    private static void instanceCarFactory() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-instance-factory.xml");
        Car car = (Car) applicationContext.getBean("car");
        System.out.println(car);
    }
}
