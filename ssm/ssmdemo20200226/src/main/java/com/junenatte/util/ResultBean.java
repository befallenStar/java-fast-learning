package com.junenatte.util;

import java.io.Serializable;

public class ResultBean implements Serializable {
    private String code;
    private String msg;
    private Object obj;

    public ResultBean() {
        this.code="12138";
        this.msg="success";
    }

    public ResultBean(Object obj) {
        this.code="12138";
        this.msg="success";
        this.obj = obj;
    }

    public ResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
