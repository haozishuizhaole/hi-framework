package cc.chenzhihao.hi.framework.core.exception;

/**
 * 异常工具
 *
 * @author jacksonchenzhihao
 * @date 2021-11-18 16:19
 */
public class Exceptions {

    public static SystemException toSystemException(Throwable e) {
        return new SystemException(e.getMessage(), e);
    }

}
