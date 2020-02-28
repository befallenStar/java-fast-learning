package com.junenatte.imooc.util;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "返回结果集")
public class ResultBean<T> implements Serializable {
    @ApiModelProperty(value = "结果状态码")
    private Integer code;
    @ApiModelProperty(value = "结果信息")
    private String msg;
    @ApiModelProperty(value = "结果数据")
    private T data;

    /**
     * 状态码枚举
     */
    public enum Code {
        /**
         * success      12138   表示成功
         * failure      12139   表示失败
         * exception    12140   表示异常
         */
        success, failure, exception
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 带返回数据，通过状态码构造返回结果
     *
     * @param code 状态码
     * @param msg  提示信息
     * @param data 返回数据
     */
    public ResultBean(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 带返回数据，通过状态码代称构造返回结果
     *
     * @param code 状态码代称
     * @param msg  提示信息
     * @param data 返回数据
     */
    public ResultBean(Code code, String msg, T data) {
        switch (code) {
            case success:
                this.code = 12138;
                break;
            case failure:
                this.code = 12139;
                break;
            case exception:
                this.code = 12140;
                break;
            default:
                this.code = 12141;
                break;
        }
        this.msg = msg;
        this.data = data;
    }

    /**
     * 不带返回数据，通过状态码构造返回结果
     *
     * @param code 状态码
     * @param msg  提示信息
     */
    public ResultBean(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 不带返回数据，通过状态码代称构造返回结果
     *
     * @param code 状态码代称
     * @param msg  提示信息
     */
    public ResultBean(Code code, String msg) {
        switch (code) {
            case success:
                this.code = 12138;
                break;
            case failure:
                this.code = 12139;
                break;
            case exception:
                this.code = 12140;
                break;
            default:
                this.code = 12141;
                break;
        }
        this.msg = msg;
    }
}

