package com.dream.core.common.util;

import com.dream.core.common.DreamException;
import com.dream.core.common.wrapper.Wrapper;

/**
 * <p>Title:      CheckArgumentUtil. </p>
 * <p>Description 校验 </p>
 *
 * @author         <a href="liqd163@163.com"/>李清栋</a>
 * @CreateDate     2018/1/8 16:03
 */
public class CheckArgumentUtil {
    /**
     * 校验
     * @param result 正确结果
     * @param message 异常信息
     */
    public static void checkArgument(boolean result, String message) throws DreamException {
        if(!result){
            throw new DreamException(Wrapper.ResultCode.ERROR.getCode(), message);
        }
    }

}
