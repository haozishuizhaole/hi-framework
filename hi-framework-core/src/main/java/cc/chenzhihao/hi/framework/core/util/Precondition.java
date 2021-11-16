package cc.chenzhihao.hi.framework.core.util;

/**
 * 断言工具
 *
 * @author jacksonchenzhihao
 * @date 2021-11-10 19:08
 */
public final class Precondition {

    /**
     * 参数校验，会抛出 IllegalArgumentException 异常
     *
     * @param condition    条件
     * @param errorMessage 错误信息
     */
    public static void checkArgument(boolean condition, String errorMessage) {
        if (!condition) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
