package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.PurchaseHistory;
import com.junenatte.imooc.dao.PurchaseHistoryMapper;
import com.junenatte.imooc.dao.ShoppingCartMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "购买记录管理", tags = "购买记录管理")
@RestController
@RequestMapping("purchase_history")
public class PurchaseHistoryController extends BaseController {
    @Autowired
    private PurchaseHistoryMapper mapper;

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @ApiOperation(value = "购买记录查询")
    @GetMapping("my")
    public ResultBean<List<Map>> my() {
        ResultBean<List<Map>> resultBean;
        try {
            List<Map> purchaseHistoryList = mapper.selectByUserId(getCurrentImoocUser().getId());
            resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", purchaseHistoryList);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常");
        }
        return resultBean;
    }

    @ApiOperation(value = "添加购买记录")
    @ApiImplicitParams({
            @ApiImplicitParam(name="ids",value="项目id串",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="prices",value="项目价格串",dataType = "String",paramType = "query")
    })
    @GetMapping("add")
    public ResultBean<Void> add(String ids, String prices) {
        ResultBean<Void> resultBean;
        try {
            String[] id = ids.split("[,]");
            String[] price = prices.split("[,]");
            Integer userId = getCurrentImoocUser().getId();
            int total = 0;
            for (int i = 0; i < id.length; i++) {
                PurchaseHistory purchaseHistory = new PurchaseHistory();
                purchaseHistory.setUserId(userId);
                purchaseHistory.setProjectId(Integer.parseInt(id[i]));
                purchaseHistory.setPurchasePrice(Float.parseFloat(price[i]));
                purchaseHistory.setPurchaseTime(new Date());
                int rows = mapper.insertSelective(purchaseHistory);
                total += rows;
            }
            if (total == id.length) {
                for (String s : id) {
                    Map<String, Integer> map = new HashMap<>();
                    map.put("userId", userId);
                    map.put("projectId", Integer.parseInt(s));
                    shoppingCartMapper.deleteByProjectId(map);
                }
            }
            resultBean = new ResultBean<>(ResultBean.Code.success, "购买成功");
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "购买异常");
        }
        return resultBean;
    }
}
