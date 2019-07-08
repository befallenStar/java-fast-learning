package cn.edu.njnu.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import cn.edu.njnu.bean.Course;
import cn.edu.njnu.bean.Video;
import cn.edu.njnu.service.VideoService;
import cn.edu.njnu.util.ResultBean;
import cn.edu.njnu.util.TableData;

@Component
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("{page}")
    public String show(@PathVariable("page") String page) {
        return "video/" + page;
    }

    @RequestMapping("list")
    @ResponseBody
    public Object queryVideoByCourseId(Integer courseId, Integer page, Integer limit) {
        page = page == null ? 1 : page;
        limit = limit == null ? 10 : limit;
        PageHelper.startPage(page, limit);
        List<Video> list = videoService.queryVideoByCourseId(courseId);
        PageInfo<Video> info = new PageInfo<>(list);
        return new TableData<>(info.getList(), (int) info.getTotal());
    }

    @RequestMapping("play")
    public String play(@RequestParam("videoName") String videoName, HttpSession session) {
        session.setAttribute("videoName", videoName);
        return "video/player";
    }

    @RequestMapping(value = "upload", headers = "content-type=multipart/*", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadFile(@RequestParam("file") MultipartFile file, Integer courseId, @RequestParam("chapter") String chapter, HttpServletRequest request) {
        ResultBean resultBean;
        if (chapter == null || chapter.equals(""))
            return new ResultBean(ResultBean.CODE.FAIL);
        Course course = new Course();
        course.setCourseId(courseId);
        if (file != null && !file.isEmpty()) {
            String realName = file.getOriginalFilename();
            String path = request.getSession().getServletContext().getRealPath("/") + "static\\video\\";
            try {
                file.transferTo(new File(path + realName));
                Video video = new Video(null, course, chapter, realName);
                videoService.uploadFile(video);
                resultBean = new ResultBean(ResultBean.CODE.SUCCESS);
            } catch (IOException e) {
                resultBean = new ResultBean(ResultBean.CODE.EXCEPTION);
                e.printStackTrace();
            }
        } else
            resultBean = new ResultBean(ResultBean.CODE.FAIL);
        return resultBean;
    }
}
