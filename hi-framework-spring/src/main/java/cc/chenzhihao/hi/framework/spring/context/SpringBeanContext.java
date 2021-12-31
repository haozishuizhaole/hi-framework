package cc.chenzhihao.hi.framework.spring.context;

import cc.chenzhihao.hi.framework.core.context.BeanContext;
import org.springframework.beans.BeansException;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * BeanContext的Spring实现
 *
 * @author jacksonchenzhihao
 * @date 2021-11-11 15:18
 */
public class SpringBeanContext implements BeanContext, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        // 注册beanContext
        register();
    }

    @Override
    public <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }

    @Override
    public <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    @Override
    public <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

}
