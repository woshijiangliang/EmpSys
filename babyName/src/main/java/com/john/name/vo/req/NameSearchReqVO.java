package com.john.name.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author jiangliang
 * @date 2022/8/12 2:41 PM
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("名字查询reqVO")
public class NameSearchReqVO extends PageParam {
    @ApiModelProperty("姓")
    @NotEmpty(message = "姓氏不能为空")
    private String firstName;

    @ApiModelProperty("性别")
    @NotNull(message = "性别不能为空")
    private Integer sex;

    @ApiModelProperty("包含的字")
    private String containsWord;
}
