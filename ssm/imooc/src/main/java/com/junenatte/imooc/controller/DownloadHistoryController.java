package com.junenatte.imooc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junenatte.imooc.dao.DownloadHistoryMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "下载记录管理", tags = "下载记录管理")
@RestController
@RequestMapping("download_history")
public class DownloadHistoryController extends BaseController {
    @Autowired
    private DownloadHistoryMapper mapper;

    @ApiOperation(value = "下载记录查询")
    @GetMapping("my")
    public ResultBean<PageInfo<Map>> my(Integer index, Integer size) {
        ResultBean<PageInfo<Map>> resultBean;
        index = null == index ? 1 : index;
        size = null == size ? 10 : size;
        try {
            PageHelper.startPage(index, size);
            List<Map> downloadHistoryList = mapper.selectByUserId(getCurrentImoocUser().getId());
            PageInfo<Map> info = new PageInfo<>(downloadHistoryList);
            resultBean = new ResultBean<>(ResultBean.Code.success, "", info);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "");
        }
        return resultBean;
    }
}
