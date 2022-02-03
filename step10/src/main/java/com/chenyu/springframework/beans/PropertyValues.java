package com.chenyu.springframework.beans;

import java.util.ArrayList;

/**
 * Bean 属性对象集合
 *
 * @author chen yu
 * @create 2022-01-29 17:12
 */
public class PropertyValues {
    private final ArrayList<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }


    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }


}
