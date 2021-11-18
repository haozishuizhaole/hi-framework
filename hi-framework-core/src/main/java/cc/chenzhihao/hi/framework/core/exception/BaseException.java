package cc.chenzhihao.hi.framework.core.exception;

/**
 * 系统异常
 *
 * @author jacksonchenzhihao
 * @date 2021-11-11 14:42
 */
public class SystemException extends RuntimeException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
