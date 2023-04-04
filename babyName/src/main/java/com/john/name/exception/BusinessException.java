package com.john.name.exception;

import lombok.Getter;

/**
 * @author john
 * @version 1.0
 * @date 2020/5/22 15:01
 */
@Getter
public class BusinessException extends RuntimeException {
    public BusinessException(String msg) {
        super(msg);
    }
}
