package org.example.test;

import org.example.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p>测试主类</p>
 *
 * @author : ninggelin
 * @date : 2022-04-11 16:30
 **/
public class Test {
    public static void main(String[] args) {
        ioc_p();
    }

    /**
     * 传统创建实例方式
     */
    private static void origin_method() {
        Student student = new Student();
        student.setId(1L);
        student.setName("张三");
        student.setAge(22);
        System.out.println(student);
    }

    /**
     * ioc创建实例方式 通过id获取
     */
    private static void ioc_method() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = (Student) applicationContext.getBean("student");
        System.out.println(student);
    }

    /**
     * ioc创建实例方式 通过运行时类获取bean
     */
    private static void ioc_runtime_class_method() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean(Student.class);
        System.out.println(student);
    }

    /**
     * ioc 通过构造方法创建实例
     */
    private static void ioc_construct_method() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student2 = (Student) applicationContext.getBean("student2");
        Student student3 = (Student) applicationContext.getBean("student3");
        System.out.println(student2);
        System.out.println(student3);
    }

    /**
     * ioc 给bean注入集合
     */
    private static void ioc_list() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student4 = (Student) applicationContext.getBean("student4");
        System.out.println(student4);
    }

    /**
     * ioc 继承
     */
    private static void ioc_inherit() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student4 = (Student) applicationContext.getBean("student5");
        System.out.println(student4);
    }

    /**
     * ioc 依赖
     */
    private static void ioc_depend() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
    }

    /**
     * ioc p命名空间
     */
    private static void ioc_p() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student4 = (Student) applicationContext.getBean("student6");
        System.out.println(student4);
    }
}
