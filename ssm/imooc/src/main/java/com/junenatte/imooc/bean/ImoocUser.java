package com.junenatte.imooc.bean;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 沈嘉豪
 */
@ApiModel(value = "用户")
public class ImoocUser implements Serializable {
    @ApiModelProperty(value = "用户编号")
    private Integer id;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户昵称")
    private String rickname;

    @ApiModelProperty(value = "用户头像")
    private String img;

    @ApiModelProperty(value = "用户注册时间")
    private Date createTime;

    @ApiModelProperty(value = "用户最后更新时间")
    private Date lastUpdate;

    @ApiModelProperty(value = "用户微信id")
    private String wechatOpenid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getRickname() {
        return rickname;
    }

    public void setRickname(String rickname) {
        this.rickname = rickname == null ? null : rickname.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getWechatOpenid() {
        return wechatOpenid;
    }

    public void setWechatOpenid(String wechatOpenid) {
        this.wechatOpenid = wechatOpenid == null ? null : wechatOpenid.trim();
    }
}