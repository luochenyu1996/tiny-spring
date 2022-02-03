package com.chenyu.springframework.context;

import com.chenyu.springframework.beans.factory.HierarchicalBeanFactory;
import com.chenyu.springframework.beans.factory.ListableBeanFactory;
import com.chenyu.springframework.core.io.ResourceLoader;

/**
 * 容器上下文顶级接口
 *
 * 上下文是基于容器的
 *
 * @author chen yu
 * @create 2022-01-29 17:20
 */
public interface ApplicationContext  extends ListableBeanFactory , HierarchicalBeanFactory, ResourceLoader,ApplicationEventPublisher {


}
