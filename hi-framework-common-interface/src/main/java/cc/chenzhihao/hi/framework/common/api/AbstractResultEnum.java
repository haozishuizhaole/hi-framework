package cc.chenzhihao.hi.framework.common.api;

/**
 * @author jacksonchenzhihao
 * @date 2021-12-31 11:14
 */
public abstract class AbstractResultEnum implements ResultEnum {

    @Override
    public int getCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getMsg() {
        throw new UnsupportedOperationException();
    }
}
