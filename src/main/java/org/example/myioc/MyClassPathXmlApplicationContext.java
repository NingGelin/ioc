package org.example.myioc;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * <p>自定义ClassPathXmlApplicationContext实现类</p>
 *
 * @author : ninggelin
 * @date : 2022-04-12 11:10
 **/
public class MyClassPathXmlApplicationContext implements MyApplicationContext {

    private Map<String, Object> beanMap = new HashMap<>();

    public MyClassPathXmlApplicationContext(String path) {
        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read("./src/main/resources/" + path);
            Element root = document.getRootElement();
            Iterator<Element> iterator = root.elementIterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");

                // 通过反射机制创建对象
                Class clazz = Class.forName(className);
                // 获取无参构造 + 创建对象
                Constructor constructor = clazz.getConstructor();
                Object object = constructor.newInstance();

                Iterator<Element> propertyIterator = element.elementIterator();
                while (propertyIterator.hasNext()) {
                    Element property = propertyIterator.next();
                    String propertyName = property.attributeValue("name");
                    String propertyValue = property.attributeValue("value");
                    Field field = clazz.getDeclaredField(propertyName);
                    String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                    Method method = clazz.getMethod(setMethodName, field.getType());
                    Object value = propertyValue;
                    if (field.getType().getName() == "long")
                    {
                        value = Long.parseLong(propertyValue);
                    }
                    method.invoke(object, value);
                }
                beanMap.put(id, object);
            }
        } catch (DocumentException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String id) {
        return beanMap.get(id);
    }
}
