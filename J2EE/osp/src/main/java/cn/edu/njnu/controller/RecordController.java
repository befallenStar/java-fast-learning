package cn.edu.njnu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import cn.edu.njnu.bean.CourseRecord;
import cn.edu.njnu.service.RecordService;
import cn.edu.njnu.util.ResultBean;
import cn.edu.njnu.util.TableData;

@Controller
@RequestMapping("record")
public class RecordController {

    @Autowired
    RecordService recordService;

    @RequestMapping("{page}")
    public String showPage(@PathVariable String page) {
        return "record/" + page;
    }

    @RequestMapping("query_selected")
    @ResponseBody
    public Object querySelectedByUserId(String userId, Integer page, Integer limit) {
        return query(userId,page,limit,0);
    }

    @RequestMapping("query_unselected")
    @ResponseBody
    public Object queryUnSelectedByUserId(String userId, Integer page, Integer limit) {
        return query(userId,page,limit,1);
    }

    @RequestMapping("query_all")
    @ResponseBody
    public Object queryAll(Integer page,Integer limit){
        return query(null,page,limit,2);
    }

    @RequestMapping("select_course")
    @ResponseBody
    public Object selectCourse(Integer userId,Integer courseId){
        ResultBean bean;
        try {
            int i = recordService.selectCourse(userId, courseId);
            if (i>0){
                bean = new ResultBean(ResultBean.CODE.SUCCESS);
            }else{
                bean = new ResultBean(ResultBean.CODE.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            bean = new ResultBean(ResultBean.CODE.EXCEPTION);
        }
        return bean;
    }

    @RequestMapping("unselect")
    @ResponseBody
    public Object unselectCourse(Integer userId,Integer courseId){
        ResultBean bean;
        try{
            int row = recordService.unselectCourse(userId,courseId);
            if (row>0){
                bean = new ResultBean(ResultBean.CODE.SUCCESS);
            }else{
                bean = new ResultBean(ResultBean.CODE.FAIL);
            }
        }catch (Exception e){
            e.printStackTrace();
            bean = new ResultBean(ResultBean.CODE.EXCEPTION);
        }
        return bean;
    }

    private Object query(String userId, Integer page, Integer limit, Integer type){
        page = page == null ? 1 : page;
        limit = limit == null ? 3 : limit;
        PageHelper.startPage(page, limit);
        List<CourseRecord> list = null;
        switch (type){
            case 0:
                list = recordService.querySelectedByUserId(Integer.parseInt(userId));
                break;
            case 1:
                list = recordService.queryUnSelectedByUserId(Integer.parseInt(userId));
                break;
            case 2:
                list = recordService.queryAll();
        }
        PageInfo<CourseRecord> info = new PageInfo<>(list);
        return new TableData<>(info.getList(), (int) info.getTotal());
    }

}
