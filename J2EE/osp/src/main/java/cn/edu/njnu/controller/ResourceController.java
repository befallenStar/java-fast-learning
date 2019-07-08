package cn.edu.njnu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njnu.bean.Course;
import cn.edu.njnu.bean.Resource;
import cn.edu.njnu.service.ResourceService;
import cn.edu.njnu.util.DownloadUtil;
import cn.edu.njnu.util.ResultBean;
import cn.edu.njnu.util.TableData;

import static cn.edu.njnu.controller.BaseController.getObject;

@Controller
@RequestMapping("resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("{page}")
    public String show(@PathVariable("page") String page) {
        return "resource/" + page;
    }

    @RequestMapping("list")
    @ResponseBody
    public Object list(Integer page, Integer limit, Integer courseId) {
        page = page == null ? 1 : page;
        limit = limit == null ? 2 : limit;
        PageHelper.startPage(page, limit);
        List<Resource> resources = resourceService.selectByCourseId(courseId);
        PageInfo<Resource> info = new PageInfo<>(resources);
        return new TableData<>(info.getList(), (int) info.getTotal());
    }

    @RequestMapping("download")
    public String downloadFile(Integer resourceId, HttpServletRequest request, HttpServletResponse response) {
        Resource resource = resourceService.queryById(resourceId);
        File file = new File(resource.getPath() + resource.getFileName());
        ServletOutputStream os = null;
        FileInputStream is = null;
        try {
            String filename = DownloadUtil.getName(request.getHeader("user-agent"), resource.getRealName());
            response.setHeader("content-disposition", "attachment;filename=" + filename);
            response.setContentType("multipart/form-data");
            is = new FileInputStream(file);
            os = response.getOutputStream();
            IOUtils.copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null)
                    os.close();
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "resource/downloadPage";
    }

    @RequestMapping(value = "upload", headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFile(@RequestParam("file") MultipartFile file, Integer courseId) {
        ResultBean resultBean;
        Course course = new Course();
        course.setCourseId(courseId);
        if (file != null && !file.isEmpty()) {
            String realName = file.getOriginalFilename();
            String fileName = UUID.randomUUID().toString() + realName.substring(realName.lastIndexOf("."));
            String path = "E:\\";
            try {
                file.transferTo(new File(path + fileName));
                Resource resource = new Resource(null, course, fileName, realName, path, 1);
                resourceService.uploadFile(resource);
                resultBean = new ResultBean(ResultBean.CODE.SUCCESS);
            } catch (IOException e) {
                resultBean = new ResultBean(ResultBean.CODE.EXCEPTION);
                e.printStackTrace();
            }
        } else {
            resultBean = new ResultBean(ResultBean.CODE.FAIL);
        }
        return resultBean;
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object delete(Integer resourceId) {
        return getObject(resourceService.deleteById(resourceId));
    }
}
