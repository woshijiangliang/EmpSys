package com.john.name.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author john
 * @version 1.0
 * @date 2020/5/22 15:18
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespData<T> {
    private Integer code = 200;

    private String msg = "success";

    private T data;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date time = new Date();

    public RespData(T data) {
        this.data = data;
    }

    public RespData(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static <T> RespData ok(T data) {
        RespData<T> respData = new RespData<>();
        respData.setData(data);
        return respData;
    }

    public static RespData error(Integer code, String msg) {
        return new RespData(code, msg);
    }
}
