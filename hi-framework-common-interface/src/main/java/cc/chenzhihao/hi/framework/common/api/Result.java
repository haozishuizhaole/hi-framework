package cc.chenzhihao.hi.framework.common.api;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/**
 * 通用返回
 *
 * @author jacksonchenzhihao
 * @date 2021-11-16 11:13
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 3510023082723933280L;

    /**
     * 响应码
     */
    private int code;

    /**
     * 描述
     */
    private String msg;

    /**
     * 数据
     */
    private T data;

    /**
     * 扩展信息
     */
    private Map<String, Object> ext;

    private Result(int code, String msg, T data, Map<String, Object> ext) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.ext = ext;
    }

    public static <E> Result<E> custom(int code, String msg) {
        return custom(code, msg, null, null);
    }

    public static <E> Result<E> custom(int code, String msg, E data) {
        return custom(code, msg, data, null);
    }

    public static <E> Result<E> custom(int code, String msg, Map<String, Object> ext) {
        return custom(code, msg, null, ext);
    }

    public static <E> Result<E> custom(int code, String msg, E data, Map<String, Object> ext) {
        return new Result<>(code, msg, data, ext);
    }

    public static <E> Result<E> custom(ResultEnum resultEnum, E data, Map<String, Object> ext) {
        return custom(resultEnum.getCode(), resultEnum.getMsg(), data, ext);
    }

    public static <E> Result<E> custom(ResultEnum resultEnum, E data) {
        return custom(resultEnum.getCode(), resultEnum.getMsg(), data, null);
    }

    public static <E> Result<E> custom(ResultEnum resultEnum) {
        return custom(resultEnum.getCode(), resultEnum.getMsg());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Map<String, Object> getExt() {
        return ext;
    }

    public void setExt(Map<String, Object> ext) {
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", ext=" + ext +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Result)) {
            return false;
        }
        Result<?> result = (Result<?>) o;
        return code == result.code && msg.equals(result.msg) && data.equals(result.data) && ext.equals(result.ext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, data, ext);
    }
}

