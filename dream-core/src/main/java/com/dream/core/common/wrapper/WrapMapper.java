package com.dream.core.common.wrapper;


/**
 * <p>Title:      WrapMapper. </p>
 * <p>Description 实体包装类 </p>
 *
 * @author <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate 2018/1/4 13:34
 */
public class WrapMapper {


    public static Wrapper wrap(Integer code, String message) {
        return new Wrapper(code, message, null, null);
    }

    public static Wrapper wrap(Integer code, String message, Exception ex) {
        return new Wrapper(code, message, null, ex);
    }

    public static Wrapper wrap(Integer code, String message, Object result) {
        return new Wrapper(code, message, result, null);
    }

    public static Wrapper success() {
        return wrap(Wrapper.ResultCode.SUCCESS.getCode(), Wrapper.ResultCode.SUCCESS.getMessage());
    }

    public static Wrapper success(Object result) {
        return wrap(Wrapper.ResultCode.SUCCESS.getCode(), Wrapper.ResultCode.SUCCESS.getMessage(), result);
    }

    public static Wrapper error(Wrapper.ResultCode resultCode) {
        return wrap(resultCode.getCode(), resultCode.getMessage());
    }

    public static Wrapper error(Wrapper.ResultCode resultCode, String message) {
        return wrap(resultCode.getCode(), message);
    }

    public static Wrapper error(String message) {
        return wrap(Wrapper.ResultCode.ERROR.getCode(), message);
    }

    public static Wrapper error() {
        return wrap(Wrapper.ResultCode.ERROR.getCode(), Wrapper.ResultCode.ERROR.getMessage());
    }

    public static Wrapper error(Exception ex) {
        return wrap(Wrapper.ResultCode.ERROR.getCode(), Wrapper.ResultCode.ERROR.getMessage(), ex);
    }

    public static Wrapper unauthorized() {
        return wrap(Wrapper.ResultCode.UNAUTHORIZED.getCode(), Wrapper.ResultCode.UNAUTHORIZED.getMessage());
    }

    public static Wrapper paramError() {
        return wrap(Wrapper.ResultCode.PARAM_ERROR.getCode(), Wrapper.ResultCode.PARAM_ERROR.getMessage());
    }

    public static Wrapper forbidden() {
        return wrap(Wrapper.ResultCode.FORBIDDEN.getCode(), Wrapper.ResultCode.FORBIDDEN.getMessage());
    }

}
