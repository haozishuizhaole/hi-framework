package cc.chenzhihao.hi.framework.core.exception;

/**
 * 系统异常
 *
 * @author jacksonchenzhihao
 * @date 2021-11-11 14:42
 */
public class SystemException extends BaseException {

    private static final long serialVersionUID = -3433844735471059454L;

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
