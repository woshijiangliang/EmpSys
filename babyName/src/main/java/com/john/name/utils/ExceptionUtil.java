package com.john.name.utils;


import com.john.name.exception.BusinessException;

/**
 * @author john
 * @version 1.0
 * @date 2020/5/22 14:50
 */
public class ExceptionUtil {
    /**
     * 抛出业务异常
     *
     * @param condition         抛出条件
     */
    public static void throwBusinessException(boolean condition, String msg) {
        if (condition) {
            throw new BusinessException(msg);
        }
    }
}
