package com.junenatte.imooc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junenatte.imooc.bean.Project;
import com.junenatte.imooc.dao.ProjectMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author 沈嘉豪
 */
@Api(value = "项目管理", tags = "项目管理")
@RestController
@RequestMapping("project")
public class ProjectController extends BaseController {
    @Autowired
    private ProjectMapper mapper;

    @Value("${imooc.upload.path.project.cover}")
    private String projectCoverPath;

    @Value("${imooc.upload.path.project.material}")
    private String projectMaterialPath;

    @GetMapping("my")
    public ResultBean<List<Project>> my() {
        ResultBean<List<Project>> resultBean;
        try {
            List<Project> projectList = mapper.selectByUserId(getCurrentImoocUser().getId());
            resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", projectList);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常");
        }
        return resultBean;
    }

    @ApiOperation(value = "项目细节查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目编号", dataType = "Integer", paramType = "query")
    })
    @GetMapping("detail")
    public ResultBean<Project> detail(Integer id) {
        ResultBean<Project> resultBean;
        try {
            Project project = mapper.selectAllByPrimaryKey(id);
            if (null != project) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", project);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常");
        }
        return resultBean;
    }

    @ApiOperation(value = "项目查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "关键字", dataType = "String", paramType = "path"),
            @ApiImplicitParam(name = "param", value = "模糊查询", dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "ordercol", value = "排序列名", dataType = "Intger", paramType = "path"),
            @ApiImplicitParam(name = "orderdesc", value = "排序顺序", dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "index", value = "分页开始页面", dataType = "Integer", paramType = "path"),
            @ApiImplicitParam(name = "size", value = "分页大小", dataType = "Integer", paramType = "path"),
    })
    @GetMapping("find")
    public ResultBean<PageInfo<Project>> find(String keyword, String param, String ordercol, String orderdesc, Integer index, Integer size) {
        ResultBean<PageInfo<Project>> resultBean;
        try {
            Map<String, String> map = new HashMap<>();
            if (null != keyword) {
                map.put("keyword", "%" + keyword + "%");
            }
            if (null != param) {
                map.put("param", "%" + param + "%");
            }
            map.put("ordercol", ordercol);
            map.put("orderdesc", orderdesc);
            index = null == index ? 1 : index;
            size = null == size ? 10 : size;
            PageHelper.startPage(index, size);
            List<Project> projects = mapper.selectByParam(map);
            PageInfo<Project> projectPageInfo = new PageInfo<>(projects);
            resultBean = new ResultBean<>(ResultBean.Code.success, "查询成功", projectPageInfo);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "查询异常");
        }
        return resultBean;
    }

    @ApiOperation(value = "用户上传项目封面", httpMethod = "POST", consumes = "multipart/form-data")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "cover", value = "封面文件", dataType = "__file", paramType = "form"),
    })
    @PostMapping("upload/cover")
    public ResultBean<String> uploadCover(@RequestParam("cover") MultipartFile cover) {
        ResultBean<String> resultBean;
        try {
            if (cover != null && cover.getSize() > 0) {
                String suffix = Objects.requireNonNull(cover.getOriginalFilename()).substring(cover.getOriginalFilename().lastIndexOf("."));
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
                String coverSavePath = "/static/" + projectCoverPath;
                String parentPath = ResourceUtils.getURL("classpath:").getPath() + coverSavePath;
                File dir = new File(parentPath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File file = new File(dir, newName);
                cover.transferTo(file);
                resultBean = new ResultBean<>(ResultBean.Code.success, "上传成功", coverSavePath + "/" + newName);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "上传失败，请重试！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultBean = new ResultBean<>(ResultBean.Code.exception, "上传异常！");
        }
        return resultBean;
    }

    @ApiOperation(value = "添加项目")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "project", value = "项目信息", dataType = "com.junenatte.imooc.bean.Project", paramType = "query")
    })
    @GetMapping("upload")
    public ResultBean<Project> upload(Project project) {
        ResultBean<Project> resultBean;
        try {
            project.setCreateTime(new Date());
            project.setLastUpdate(new Date());
            project.setCreateUser(getCurrentImoocUser().getId());
            int rows = mapper.insertSelective(project);
            if (rows > 0) {
                resultBean = new ResultBean<>(ResultBean.Code.success, "上传成功", project);
            } else {
                resultBean = new ResultBean<>(ResultBean.Code.failure, "上传失败");
            }
        } catch (Exception e) {
            resultBean = new ResultBean<>(ResultBean.Code.exception, "上传异常");
        }
        return resultBean;
    }
}
