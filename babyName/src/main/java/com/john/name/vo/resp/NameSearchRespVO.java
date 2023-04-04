package com.john.name.vo.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author jiangliang
 * @date 2022/8/12 2:48 PM
 */
@Data
@ApiModel("姓名搜索respVO")
public class NameSearchRespVO {
    @ApiModelProperty("姓名")
    private String name;
}
