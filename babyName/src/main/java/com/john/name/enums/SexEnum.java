package com.john.name.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author jiangliang
 * @date 2022/8/15 11:05 AM
 */
@Getter
@AllArgsConstructor
public enum SexEnum implements BaseEnum {
    BOY(0, "男"),
    GIRL(1, "女"),
    ALL(2, "全部"),
    ;

    private Integer code;
    private String msg;
}
