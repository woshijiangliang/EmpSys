package com.john.name.utils;

import com.john.name.enums.BaseEnum;

/**
 * author jiangliang
 * date 2020/8/21 16:22
 */
public class EnumUtil {
    public static <T extends BaseEnum> BaseEnum getByCode(Integer code, Class<T> t) {
        for (T item : t.getEnumConstants()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    public static <T extends BaseEnum> T getEnumByCode(Integer code, Class<T> t) {
        for (T item : t.getEnumConstants()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }
}
