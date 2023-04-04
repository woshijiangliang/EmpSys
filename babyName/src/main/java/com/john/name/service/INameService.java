package com.john.name.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.john.name.domain.entity.Name;
import com.john.name.vo.req.NameSearchReqVO;
import com.john.name.vo.resp.NameSearchRespVO;

/**
 * <p>
 * 名字表 服务类
 * </p>
 *
 * @author jiangliang
 * @since 2022-08-10
 */
public interface INameService extends IService<Name> {
    Page<NameSearchRespVO> search(NameSearchReqVO reqVO);
}
