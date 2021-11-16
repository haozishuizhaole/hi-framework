package cc.chenzhihao.hi.framework.spring.context;

import cc.chenzhihao.hi.framework.core.context.BeanContext;
import org.springframework.context.annotation.Bean;

/**
 * @author jacksonchenzhihao
 * @date 2021-11-16 15:23
 */
public class SpringBeanContextConfiguration {

    @Bean
    public BeanContext beanContext() {
        return new SpringBeanContext();
    }
}
