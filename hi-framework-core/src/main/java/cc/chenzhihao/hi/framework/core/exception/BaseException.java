package cc.chenzhihao.hi.framework.core.exception;

/**
 * 通用异常
 *
 * @author jacksonchenzhihao
 * @date 2021-11-11 14:42
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 2847100484320112908L;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
