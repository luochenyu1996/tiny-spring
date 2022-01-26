package com.chenyu.springframework.beans;

/**
 * bean的参数
 *
 * @author chen yu
 * @create 2022/1/26
 */
public class PropertyValue {
    private final  String name;
    private final Object value;
  




    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
