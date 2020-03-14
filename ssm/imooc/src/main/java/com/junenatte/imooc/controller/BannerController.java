package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.Banner;
import com.junenatte.imooc.dao.BannerMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author 沈嘉豪
 */
@Api(value = "首页轮播", tags = "首页轮播")
@RestController
@RequestMapping("banner")
public class BannerController extends BaseController {
    @Autowired
    private BannerMapper mapper;

    @ApiOperation(value = "查询轮播图片")
    @GetMapping("findall")
    public ResultBean<List<Banner>> findAll() {
        ResultBean<List<Banner>> resultBean;
        try {
            List<Banner> banners = mapper.selectAll();
            resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", banners);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常");
        }
        return resultBean;
    }
}
