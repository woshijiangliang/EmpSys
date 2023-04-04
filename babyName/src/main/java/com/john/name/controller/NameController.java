package com.john.name.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.john.name.service.INameService;
import com.john.name.vo.RespData;
import com.john.name.vo.req.NameSearchReqVO;
import com.john.name.vo.resp.NameSearchRespVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author jiangliang
 * @date 2022/8/8 2:59 PM
 */
@CrossOrigin
@Api(tags = "名字")
@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/name")
public class NameController {
    private INameService nameService;

    @ApiOperation(value = "名字查询")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public RespData<Page<NameSearchRespVO>> search(@RequestBody @Valid NameSearchReqVO reqVO) {
        return RespData.ok(nameService.search(reqVO));
    }
}
