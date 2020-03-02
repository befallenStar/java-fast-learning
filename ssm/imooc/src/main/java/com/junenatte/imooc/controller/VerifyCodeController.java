package com.junenatte.imooc.controller;

import com.junenatte.imooc.util.JuheMessage;
import com.junenatte.imooc.util.SessionKeyUtil;
import com.junenatte.imooc.util.VerifyCodeUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author 沈嘉豪
 */
@Api(value = "图形验证码", tags = "图形验证码")
@Controller
public class VerifyCodeController extends BaseController {
    /**
     * 获取图形验证码
     *
     * @param res http响应
     */
    @ApiOperation(value = "图形验证码")
    @GetMapping("code")
    public void getCode(HttpServletResponse res) {
        String code = VerifyCodeUtils.generateVerifyCode(4);
        session.setAttribute(SessionKeyUtil.CODE, code);
        try {
            VerifyCodeUtils.outputImage(90, 35, res.getOutputStream(), code);
            res.getOutputStream().flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取手机验证码
     *
     * @param phone 手机号码
     * @return 发送验证码结果
     */
    @ApiOperation(value = "手机验证码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号码", dataType = "String", paramType = "path")
    })
    @GetMapping("message/{phone}")
    @ResponseBody
    public String message(@PathVariable("phone") String phone) {
        String result = "";
        try {
            int code = (int) (Math.random() * 10000);
            session.setAttribute(SessionKeyUtil.MSGCODE, Integer.toString(code));
            result = JuheMessage.mobileQuery(phone, Integer.toString(code));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
