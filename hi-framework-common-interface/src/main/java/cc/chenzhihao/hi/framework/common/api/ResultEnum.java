package cc.chenzhihao.hi.framework.common.api;

/**
 * 返回信息枚举接口
 *
 * @author jacksonchenzhihao
 * @date 2021-12-31 11:12
 */
public interface ResultEnum {

    /**
     * 获取响应码
     *
     * @return 响应码
     */
    int getCode();

    /**
     * 获取响应信息
     *
     * @return 响应信息
     */
    String getMsg();
}
