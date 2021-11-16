package cc.chenzhihao.hi.framework.common.api;

import java.util.Objects;

/**
 * 通用返回
 *
 * @author jacksonchenzhihao
 * @date 2021-11-16 11:13
 */
public class Result<T> {

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

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
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
        return code == result.code && msg.equals(result.msg) && data.equals(result.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, msg, data);
    }

    public static <E> Result<E> success(E data) {
        return new Result<>(0, "success", data);
    }

    public static <E> Result<E> success(int code, String msg, E data) {
        return new Result<>(code, msg, data);
    }
}

