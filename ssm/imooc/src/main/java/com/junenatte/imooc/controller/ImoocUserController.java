package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.ImoocUser;
import com.junenatte.imooc.dao.ImoocUserMapper;
import com.junenatte.imooc.util.ResultBean;
import com.junenatte.imooc.util.SessionKeyUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author 沈嘉豪
 */
@RestController
@RequestMapping("imooc_user")
@Api(value = "用户管理", tags = "用户管理")
public class ImoocUserController {
    @Autowired
    private ImoocUserMapper mapper;

    @Autowired
    private HttpSession session;

    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "loginCode", value = "图形验证码", dataType = "String", paramType = "query"),
    })
    @PostMapping("login")
    public ResultBean<ImoocUser> login(String phone, String password, String loginCode) {
        ResultBean<ImoocUser> resultBean;
        try {
            String code = (String) session.getAttribute(SessionKeyUtil.CODE);
            if (null == code) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "验证码已失效");
                return resultBean;
            }
            if (!loginCode.equalsIgnoreCase(code)) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "验证码错误");
                return resultBean;
            }
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            map.put("password", password);
            ImoocUser imoocUser = mapper.selectByPhone(map);
            if (null != imoocUser) {
                imoocUser.setPassword("");
                resultBean = new ResultBean<>(ResultBean.Code.success, "登陆成功", imoocUser);
                session.setAttribute(SessionKeyUtil.USER, imoocUser);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "登录失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "登录异常" + e.getMessage());
        }
        return resultBean;
    }

    @ApiOperation(value = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nickname", value = "昵称", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "phone", value = "手机号", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "loginCode", value = "短信验证码", dataType = "String", paramType = "query"),
    })
    @PostMapping("signup")
    public ResultBean<ImoocUser> signup(String nickname, String phone, String password, String loginCode) {
        ResultBean<ImoocUser> resultBean;
        try {
            String code = (String) session.getAttribute(SessionKeyUtil.MSGCODE);
            if (null == code) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "验证码已失效");
                return resultBean;
            }
            if (!loginCode.equalsIgnoreCase(code)) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "验证码错误");
                return resultBean;
            }
            Map<String, String> map = new HashMap<>();
            map.put("phone", phone);
            ImoocUser imoocUser = mapper.selectByPhone(map);
            if (null != imoocUser) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "用户已存在，请直接登录！");
            } else {
                imoocUser = new ImoocUser();
                imoocUser.setRickname(nickname);
                imoocUser.setPhone(phone);
                imoocUser.setPassword(password);
                imoocUser.setCreateTime(new Date());
                imoocUser.setLastUpdate(new Date());
                int rows = mapper.insertSelective(imoocUser);
                if (rows > 0) {
                    resultBean = new ResultBean<>(ResultBean.Code.success, "注册成功", imoocUser);
                } else {
                    resultBean = new ResultBean<>(ResultBean.Code.failure, "注册失败，请重试！");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "注册异常！");
        }
        return resultBean;
    }

    @ApiOperation(value = "用户更新信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "imoocUser", value = "用户信息", dataType = "com.junenatte.imooc.bean.ImoocUser", paramType = "query"),
    })
    @PostMapping("update")
    public ResultBean<ImoocUser> update(ImoocUser imoocUser) {
        ResultBean<ImoocUser> resultBean;
        try {
            imoocUser.setLastUpdate(new Date());
            int rows = mapper.updateByPrimaryKeySelective(imoocUser);
            if (rows > 0) {
                ImoocUser iUser = mapper.selectByPrimaryKey(imoocUser.getId());
                iUser.setPassword("");
                session.setAttribute(SessionKeyUtil.USER, iUser);
                resultBean = new ResultBean<>(ResultBean.Code.success, "更新成功", iUser);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "更新失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "更新异常异常！");
        }
        return resultBean;
    }

    @ApiOperation(value = "用户修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "oldPwd", value = "原密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", dataType = "String", paramType = "query"),
    })
    @PostMapping("update/password")
    public ResultBean<ImoocUser> updatePassword(Integer id, String oldPwd, String newPwd) {
        ResultBean<ImoocUser> resultBean;
        try {
            ImoocUser imoocUser = mapper.selectByPrimaryKey(id);
            if (!oldPwd.equals(imoocUser.getPassword())) {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "原密码错误");
                return resultBean;
            }
            imoocUser.setPassword(newPwd);
            int rows = mapper.updateByPrimaryKeySelective(imoocUser);
            if (rows > 0) {
                ImoocUser iUser=mapper.selectByPrimaryKey(imoocUser.getId());
                iUser.setPassword("");
                resultBean = new ResultBean<>(ResultBean.Code.success, "更新成功", iUser);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "更新失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "更新异常异常！");
        }
        return resultBean;
    }

    @ApiOperation(value = "用户上传头像")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Integer", paramType = "query"),
            @ApiImplicitParam(name = "oldPwd", value = "原密码", dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", dataType = "String", paramType = "query"),
    })
    @PostMapping("upload/img")
    public ResultBean<ImoocUser> uploadImg(Integer id, @RequestParam("img") MultipartFile img) {
        ResultBean<ImoocUser> resultBean;
        try {
            if (img != null && img.getSize() > 0) {
                String suffix = Objects.requireNonNull(img.getOriginalFilename()).substring(img.getOriginalFilename().lastIndexOf("."));
                String[] suffixes = new String[]{
                        ".jpg", ".jpeg", ".png", ".gif"
                };
                boolean flag = false;
                for (String s : suffixes) {
                    if (suffix.toLowerCase().endsWith(s)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    resultBean = new ResultBean<>(ResultBean.Code.failure, "文件类型只支持\".jpg\",\".jpeg\",\".png\",\".gif\"");
                    return resultBean;
                }
                String newName = UUID.randomUUID().toString() + suffix;
                String parentPath = ResourceUtils.getURL("classpath:").getPath();
                File file = new File(parentPath, newName);
                img.transferTo(file);
                ImoocUser imoocUser = mapper.selectByPrimaryKey(id);
                imoocUser.setImg(parentPath + newName);
                imoocUser.setLastUpdate(new Date());
                int rows = mapper.updateByPrimaryKeySelective(imoocUser);
                if (rows > 0) {
                    resultBean = new ResultBean<>(ResultBean.Code.success, "上传成功", imoocUser);
                } else {
                    resultBean = new ResultBean<>(ResultBean.Code.failure, "上传失败，请重试！");
                }
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "上传失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "更新异常异常！");
        }
        return resultBean;
    }

    @ApiOperation(value="用户注销")
    @PostMapping("loginOut")
    public ResultBean<ImoocUser> loginOut(){
        session.invalidate();
        return new ResultBean<>(ResultBean.Code.success,"注销成功");
    }

    @ApiOperation(value = "查询单一用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", dataType = "Integer", paramType = "path")
    })
    @GetMapping("findById/{id}")
    public Object findById(@PathVariable("id") Integer id) {
        ResultBean<ImoocUser> resultBean;
        ImoocUser imoocUser = mapper.selectByPrimaryKey(id);
        try {
            if (null != imoocUser) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", imoocUser);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "查询失败");
            }
        } catch (Exception e) {
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常" + e.getMessage());
        }
        return resultBean;
    }
}
