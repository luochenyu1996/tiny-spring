package com.chehyu.springframework.beans;

/**
 * bean属性信息
 *
 * @author chen yu
 * @create 2022/1/22
 */
public class PropertyValue {

    private final String name;
    private final  Object value;

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
