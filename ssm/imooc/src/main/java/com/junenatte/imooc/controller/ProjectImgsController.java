package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.ProjectImgs;
import com.junenatte.imooc.dao.ProjectImgsMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Objects;
import java.util.UUID;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author 沈嘉豪
 */
@RestController
@RequestMapping("project_imgs")
public class ProjectImgsController extends BaseController {
    @Autowired
    private ProjectImgsMapper mapper;

    @Value("${imooc.upload.path.project.imgs}")
    private String imgsPath;

    @ApiOperation(value = "用户上传项目图片", httpMethod = "POST", consumes = "multipart/form-data")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目id", dataType = "__file", paramType = "form"),
            @ApiImplicitParam(name = "text", value = "图片文本", dataType = "__file", paramType = "form"),
            @ApiImplicitParam(name = "order", value = "图片顺序", dataType = "__file", paramType = "form"),
            @ApiImplicitParam(name = "img", value = "图片文件", dataType = "__file", paramType = "form"),
    })
    @PostMapping("upload/img")
    public ResultBean<ProjectImgs> uploadImg(Integer id, String text, Integer order, @RequestParam("img") MultipartFile img) {
        ResultBean<ProjectImgs> resultBean;
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
                String imgSavePath = "/static/" + imgsPath;
                String parentPath = ResourceUtils.getURL("classpath:").getPath() + imgSavePath;
                File dir = new File(parentPath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File file = new File(dir, newName);
                img.transferTo(file);
                ProjectImgs projectImgs = new ProjectImgs();
                projectImgs.setImgUrl(imgsPath + "/" + newName);
                projectImgs.setImgText(text);
                projectImgs.setImgOrder(order);
                projectImgs.setProjectId(id);
                int rows = mapper.insertSelective(projectImgs);
                if (rows > 0) {
                    resultBean = new ResultBean<>(ResultBean.Code.success, "上传成功", projectImgs);
                } else {
                    resultBean = new ResultBean<>(ResultBean.Code.failure, "上传失败，请重试！");
                }
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "上传失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "上传异常！");
        }
        return resultBean;
    }
}
