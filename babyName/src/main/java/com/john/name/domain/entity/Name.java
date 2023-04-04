package com.john.name.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 名字表
 * </p>
 *
 * @author jiangliang
 * @since 2022-08-10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_name")
public class Name implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 姓
     */
    private String firstName;

    /**
     * 名
     */
    private String lastName;

    /**
     * 性别（0男 1女）
     */
    private Integer sex;

    /**
     * 推荐度
     */
    private Integer score;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除(0-否,1-是)
     */
    private Boolean deleted;
}
