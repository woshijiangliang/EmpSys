package com.john.name.service.impl;


import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.john.name.domain.dao.NameMapper;
import com.john.name.domain.entity.Name;
import com.john.name.enums.SexEnum;
import com.john.name.service.INameService;
import com.john.name.vo.req.NameSearchReqVO;
import com.john.name.vo.resp.NameSearchRespVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 名字表 服务实现类
 * </p>
 *
 * @author jiangliang
 * @since 2022-08-10
 */
@Service
public class NameServiceImpl extends ServiceImpl<NameMapper, Name> implements INameService {
    @Override
    public Page<NameSearchRespVO> search(NameSearchReqVO reqVO) {
        Page<Name> page = new Page<>(reqVO.getPage(), reqVO.getSize());
        this.page(page, Wrappers.<Name>lambdaQuery()
                                .eq(Name::getFirstName, reqVO.getFirstName())
                                .eq(SexEnum.BOY.getCode().equals(reqVO.getSex()) || SexEnum.GIRL.getCode().equals(reqVO.getSex()), Name::getSex, reqVO.getSex())
                                .like(StringUtils.isNotBlank(reqVO.getContainsWord()), Name::getLastName, reqVO.getContainsWord())
                                .eq(Name::getDeleted, Boolean.FALSE));
        Page<NameSearchRespVO> newPage = new Page<>();
        BeanUtils.copyProperties(page, newPage);
        List<Name> records = page.getRecords();
        if (CollectionUtil.isEmpty(records)) {
            newPage.setRecords(Lists.newArrayList());
        } else {
            newPage.setRecords(records.stream().map(record -> {
                NameSearchRespVO respVO = new NameSearchRespVO();
                respVO.setName(record.getFirstName() + record.getLastName());
                return respVO;
            }).collect(Collectors.toList()));
        }

        return newPage;
    }
}
