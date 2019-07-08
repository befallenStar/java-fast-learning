package cn.edu.njnu.controller;

import cn.edu.njnu.util.ResultBean;

public class BaseController {
    static Object getObject(int i) {
        ResultBean resultBean;
        try {
            if (i > 0) {
                resultBean = new ResultBean(ResultBean.CODE.SUCCESS);
            } else {
                resultBean = new ResultBean(ResultBean.CODE.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean(ResultBean.CODE.EXCEPTION);
        }
        return resultBean;
    }
}
