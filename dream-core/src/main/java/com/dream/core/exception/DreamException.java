package com.dream.core.exception;

/**
 * <p>Title:      DreamException. </p>
 * <p>Description TODO </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 11:32
 */
public class DreamException extends Exception {

    public DreamException(String message){
        super(message);
        this.code = 500;
        this.message = message;
    }

    public DreamException(Integer code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public DreamException(Integer code, String message, Throwable e) {
        super(message, e);
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
