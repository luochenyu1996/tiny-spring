package com.chehyu.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * bean 属性集合
 * @author chen yu
 * @create 2022/1/22
 */
public class PropertyValues {

    private  final List<PropertyValue> propertyValues=new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValues.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValues.toArray(new PropertyValue[0]);
    }

    private  PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : this.propertyValues) {
            if(pv.getName().equals(propertyName)){
                return pv;
            }
        }
        return  null;
    }

}
