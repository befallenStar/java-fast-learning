package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.PurchaseHistory;
import com.junenatte.imooc.bean.ShoppingCart;
import com.junenatte.imooc.dao.PurchaseHistoryMapper;
import com.junenatte.imooc.dao.ShoppingCartMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

/**
 * @author 沈嘉豪
 */
@Api(value = "购物车管理", tags = "购物车管理")
@RestController
@RequestMapping("shopping_cart")
public class ShoppingCartController extends BaseController {
    @Autowired
    private ShoppingCartMapper mapper;
    @Autowired
    private PurchaseHistoryMapper purchaseHistoryMapper;

    @ApiOperation(value = "查询购物车")
    @GetMapping("my")
    public ResultBean<List<Map>> my() {
        ResultBean<List<Map>> resultBean;
        try {
            List<Map> shoppingCartList = mapper.selectByUserId(getCurrentImoocUser().getId());
            resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", shoppingCartList);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常");
        }
        return resultBean;
    }

    @ApiOperation(value = "添加购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "projectId", value = "项目id", dataType = "Integer", paramType = "path")
    })
    @GetMapping("insert/{projectId}")
    public ResultBean<ShoppingCart> insert(@PathVariable("projectId") Integer projectId) {
        ResultBean<ShoppingCart> resultBean;
        try {
            Integer userId = getCurrentImoocUser().getId();
            Map<String, Integer> map = new HashMap<>();
            map.put("userId", userId);
            map.put("projectId", projectId);
            ShoppingCart shoppingCart = mapper.selectByUserIdAndProjectId(map);
            if (null != shoppingCart) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "购物车已存在该项目！");
                return resultBean;
            }
            PurchaseHistory purchaseHistory = purchaseHistoryMapper.selectByUserIdAndProjectId(map);
            if (null != purchaseHistory) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "您已购买过该项目！");
                return resultBean;
            }
            shoppingCart = new ShoppingCart();
            shoppingCart.setUserId(userId);
            shoppingCart.setProjectId(projectId);
            shoppingCart.setCreateTime(new Date());
            int rows = mapper.insertSelective(shoppingCart);
            if (rows > 0) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "添加成功", shoppingCart);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "添加失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "添加异常");
        }
        return resultBean;
    }

    @ApiOperation(value="购物车删除")
    @ApiImplicitParams(
            @ApiImplicitParam(name="projectId",value="项目id",dataType = "Integer",paramType = "path")
    )
    @GetMapping("delete/{projectId}")
    public ResultBean<List<Map>> delete(@PathVariable("projectId") Integer projectId){
        ResultBean<List<Map>> resultBean;
        try {
            Map<String,Integer> map=new HashMap<>();
            map.put("projectId",projectId);
            map.put("userId",getCurrentImoocUser().getId());
            int rows=mapper.deleteByProjectId(map);
            if(rows>0) {
                List<Map> shoppingCartList = mapper.selectByUserId(getCurrentImoocUser().getId());
                resultBean = new ResultBean<>(ResultBean.Code.success, "删除成功", shoppingCartList);
            }else{
                resultBean= new ResultBean<>(ResultBean.Code.failure, "删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "删除异常");
        }
        return resultBean;
    }
}
