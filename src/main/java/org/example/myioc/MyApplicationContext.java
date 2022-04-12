package org.example.myioc;

/**
 * 自定义ApplicationContext接口
 *
 * @author ninggelin
 * @date 2022-04-12 11:08:31
 */
public interface MyApplicationContext {
    Object getBean(String id);
}
