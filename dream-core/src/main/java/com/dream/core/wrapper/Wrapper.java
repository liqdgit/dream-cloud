package com.dream.core.wrapper;

import java.io.Serializable;

/**
 * <p>Title:      Wrapper. </p>
 * <p>Description 返回结果包装类 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/4 13:25
 */
public class Wrapper<T> implements Serializable {

    private static final long serialVersionUID = -8627210024985553696L;

    public Wrapper(Integer code, String message, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
    }

    public Wrapper(){
    }

    /**
     * 响应编码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 返回结果
     */
    private T result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean is() {
        if (code == null || !code.equals(ResultCode.SUCCESS.getCode())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public enum ResultCode {

        SUCCESS(200, "操作成功"),

        ERROR(500, "系统异常"),

        UNAUTHORIZED(401, "未授权"),

        PARAM_ERROR(400, "参数错误"),

        FORBIDDEN(403, "拒绝访问"),
        ;

        private Integer code;

        private String message;

        ResultCode(Integer code, String message) {
            this.code = code;
            this.message = message;
        }

        public Integer getCode() {
            return code;
        }

        public void setCode(Integer code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
