package com.nrsc.elegant.util;

import com.nrsc.elegant.enums.ResultEnum;
import com.nrsc.elegant.exception.ElegantCheckedException;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/***
 * @author : Sun Chuan
 * @date : 2019/11/19 15:08
 * Description: 通过静态方法获取IOC容器中bean实例的方法
 */
@Component
public class ApplicationContextUtils implements ApplicationContextAware {
    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    /***
     * 从IOC容器中根据类型拿bean实例
     * @param clazz
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T getBeanByType(Class<T> clazz) throws ElegantCheckedException {
        if (applicationContext == null) {
            throw new ElegantCheckedException(ResultEnum.FAILURE);
        }

        return applicationContext.getBean(clazz);
    }

    /***
     * 从IOC容器中根据beanName拿bean实例
     * @param beanName
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T getBeanByName(String beanName) throws ElegantCheckedException {
        if (applicationContext == null) {
            throw new ElegantCheckedException(ResultEnum.FAILURE);
        }
        return (T) applicationContext.getBean(beanName);
    }
}
