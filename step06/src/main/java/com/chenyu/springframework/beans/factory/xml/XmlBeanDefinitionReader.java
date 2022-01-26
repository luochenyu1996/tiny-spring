package com.chenyu.springframework.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.chenyu.springframework.beans.BeansException;
import com.chenyu.springframework.beans.PropertyValue;
import com.chenyu.springframework.beans.factory.config.BeanDefinition;
import com.chenyu.springframework.beans.factory.config.BeanReference;
import com.chenyu.springframework.beans.factory.support.AbstractBeanDefinitionReader;
import com.chenyu.springframework.beans.factory.support.BeanDefinitionRegister;
import com.chenyu.springframework.core.io.Resource;
import com.chenyu.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 具体实现
 *
 * @author chen yu
 * @create 2022/1/26
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public XmlBeanDefinitionReader(BeanDefinitionRegister register) {
        super(register);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegister register, ResourceLoader resourceLoader) {
        super(register, resourceLoader);
    }


    /**
     *  具体实现
     *
     */
    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            try(InputStream inputStream = resource.getInputStream()){
                doLoadBeanDefinitions(inputStream);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw  new BeansException("IOException parsing XML document from "+resource,e);
        }

    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException {
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }


    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String... locations) throws BeansException {
        for (String location : locations) {
            loadBeanDefinitions(location);
        }
    }

    /**
     * 具体实现
     *
     */
     protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException{
         Document doc = XmlUtil.readXML(inputStream);
         Element root = doc.getDocumentElement();
         NodeList childNodes = root.getChildNodes();

         for (int i = 0; i < childNodes.getLength(); i++) {
             //判断元素
             if(!(childNodes.item(i) instanceof Element)) continue;

             //判断对象  解析bean 标签
             if(!"bean".equals(childNodes.item(i).getNodeName())) continue;

             //解析标签
             Element bean = (Element) childNodes.item(i);
             String id = bean.getAttribute("id");
             String name = bean.getAttribute("name");
             String className = bean.getAttribute("class");

             //获取class
             Class<?> clazz = Class.forName(className);

             //优先级 id>name
             String beanName = StrUtil.isNotEmpty(id) ? id : name;

             if(StrUtil.isNotEmpty(beanName)){
                  beanName = StrUtil.lowerFirst(clazz.getSimpleName());
             }

             //定义bean
             BeanDefinition beanDefinition = new BeanDefinition(clazz);
             //获取属性  并填充
             for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                 if(!(bean.getChildNodes().item(j) instanceof Element)) continue;
                 //  解析property 标签
                 if(!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;
                 //property  和上面对应  为标签名字
                 Element property = (Element) bean.getChildNodes().item(j);
                 String attrName = property.getAttribute("name");
                 String attrValue = property.getAttribute("value");
                 String attrRef = property.getAttribute("ref");
                 //获取 属性值 :  引入对象 、值对象
                 Object value= StrUtil.isNotEmpty(attrRef)?new BeanReference(attrRef):attrValue;
                 //创建属性信息
                 PropertyValue propertyValue = new PropertyValue(attrName, value);
                 beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
             }

             if(getRegister().containsBeanDefinition(beanName)){
                 throw new BeansException("Duplicate beanName ["+beanName+"] is not allowed");
             }
             getRegister().registerBeanDefinition(beanName,beanDefinition);

         }

     }
}
