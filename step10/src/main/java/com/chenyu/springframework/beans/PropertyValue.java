package com.chenyu.springframework.beans;

/**
 * Bean的属性
 *
 * @author chen yu
 * @create 2022-01-29 17:10
 */
public class PropertyValue {
    //bean 属性的名称
    private final String name;
    //bean 属性的内容
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
