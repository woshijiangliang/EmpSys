package com.john.name.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jiangliang
 * @date 2021/6/29 16:22
 */
@Data
@ApiModel("分页param")
public class PageParam implements Serializable {
    private static final long serialVersionUID = -3134028486227973938L;

    @ApiModelProperty("页码")
    private Long page = 1L;

    @ApiModelProperty("页容量")
    private Long size = 10L;
}
