package cc.chenzhihao.hi.framework.core.exception;

import cc.chenzhihao.hi.framework.common.api.ResultEnum;

/**
 * 业务异常
 *
 * @author jacksonchenzhihao
 * @date 2021-12-31 17:25
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = -4235734246189196252L;

    /**
     * 错误码
     */
    private final int errCode;

    public BusinessException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.errCode = resultEnum.getCode();
    }

    public BusinessException(int errCode, String message) {
        super(message);
        this.errCode = errCode;
    }

    public BusinessException(int errCode, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
    }

    public int getErrCode() {
        return errCode;
    }

    @Override
    public String toString() {
        return "BusinessException{" +
                "errCode=" + errCode +
                "} " + super.toString();
    }
}
