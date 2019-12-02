package com.nrsc.elegant.aop;

import com.nrsc.elegant.annotation.LogAnnotation;
import com.nrsc.elegant.service.impl.AopDemoServiceImpl;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

/***
 *  @author : Sun Chuan
 *  @date : 2019/12/1 22:19
 *  Description：
 */
class LogAspectTest {

    @Test
    public void testAnno() {
        Class clazz = AopDemoServiceImpl.class;
        //获取注解类对象
        Class anno = LogAnnotation.class;
        //通过反射判断类上是否加了指定的注解_
        if (clazz.isAnnotationPresent(anno)) {
            //通过反射获取注解的实例
            LogAnnotation annotation = (LogAnnotation) clazz.getAnnotation(anno);
            //打印注解携带的信息
            //System.out.println(annotation.key());
            //System.out.println(annotat ion.cacheName());
            System.out.println(annotation.needLog());
        }
        //通过反射获取类里面的所有方法
        Method[] methods = clazz.getMethods();
        //遍历所有的方法，判断方法上是否加了指定的注解
        for (Method method : methods) {
            if (method.isAnnotationPresent(anno)) {
                //获取注解的实例
                LogAnnotation annotation = (LogAnnotation) method.getAnnotation(anno);
                //打印注解携带的信息
                //system.out.println(annotation.key());
                //System.out.print ln (annotation.cacheName());
                System.out.println(annotation.needLog());
            }
        }
    }


}