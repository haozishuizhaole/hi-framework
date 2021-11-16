package cc.chenzhihao.hi.framework.spring.enable;

import cc.chenzhihao.hi.framework.spring.context.SpringBeanContextConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 启用SpringBeanContext
 *
 * @author jacksonchenzhihao
 * @date 2021-11-16 15:22
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(SpringBeanContextConfiguration.class)
public @interface EnableSpringBeanContext {
}
