package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>汽车类</p>
 *
 * @author : ninggelin
 * @date : 2022-04-11 17:51
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    private long id ;
    private String name;
}
