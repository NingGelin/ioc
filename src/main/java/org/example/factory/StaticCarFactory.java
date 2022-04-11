package org.example.factory;

import org.example.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>静态工厂</p>
 *
 * @author : ninggelin
 * @date : 2022-04-11 17:52
 **/
public class StaticCarFactory {
    private static Map<String, Car> carMap = new HashMap<>();

    static {
        carMap.put("1", new Car(1L, "宝马"));
        carMap.put("2", new Car(2L, "奔驰"));
    }

    public static Car getCar(String id) {
        return carMap.get(id);
    }
}
