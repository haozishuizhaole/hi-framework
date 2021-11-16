package cc.chenzhihao.hi.framework.core.context;


import cc.chenzhihao.hi.framework.core.exception.BeanHolderException;
import cc.chenzhihao.hi.framework.core.util.Precondition;

import java.util.Objects;

/**
 * Bean容器持有者
 * <p>
 * 某些场景下，不希望Bean容器的实现侵入到业务代码中，可以使用BeanContextHolder隔离这部分代码和依赖
 *
 * @author jacksonchenzhihao
 * @date 2021-11-11 14:33
 */
public final class BeanContextHolder {

    private static BeanContext context;

    private static void checkContext() {
        if (Objects.isNull(context)) {
            throw new BeanHolderException("BeanContext is not init");
        }
    }

    public static void setContext(BeanContext context) {
        Precondition.checkArgument(Objects.nonNull(context), "context can not be null");
        synchronized (BeanContextHolder.class) {
            BeanContextHolder.context = context;
        }
    }

    public static <T> T getBean(String name) {
        checkContext();
        return context.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        checkContext();
        return context.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        checkContext();
        return context.getBean(name, clazz);
    }
}
