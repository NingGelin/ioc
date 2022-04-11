package org.example.factory;

import org.example.entity.Car;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>实例工厂</p>
 *
 * @author : ninggelin
 * @date : 2022-04-11 17:52
 **/
public class InstanceCarFactory {
    private Map<String, Car> carMap;

    public InstanceCarFactory() {
        carMap = new HashMap<>();
        carMap.put("1", new Car(1, "宝马"));
        carMap.put("2", new Car(2, "奔驰"));
    }

    public Car getCar(String id) {
        return carMap.get(id);
    }
}
