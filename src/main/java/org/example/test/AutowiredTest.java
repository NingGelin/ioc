package org.example.test;

import org.example.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>自动装载测试</p>
 *
 * @author : ninggelin
 * @date : 2022-04-11 18:12
 **/
public class AutowiredTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("autowired.xml");
        Person person1 = (Person) applicationContext.getBean("person1");
        System.out.println(person1);
        Person person2 = (Person) applicationContext.getBean("person2");
        System.out.println(person2);
    }
}
