package com.junenatte.imooc.controller;

import com.junenatte.imooc.bean.DownloadHistory;
import com.junenatte.imooc.bean.ProjectMaterial;
import com.junenatte.imooc.bean.ProjectMaterialType;
import com.junenatte.imooc.dao.DownloadHistoryMapper;
import com.junenatte.imooc.dao.ProjectMaterialMapper;
import com.junenatte.imooc.dao.ProjectMaterialTypeMapper;
import com.junenatte.imooc.util.ResultBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author 沈嘉豪
 */
@RestController
@RequestMapping("project_material")
public class ProjectMaterialController extends BaseController {
    @Autowired
    private ProjectMaterialMapper mapper;

    @Autowired
    private ProjectMaterialTypeMapper projectMaterialTypeMapperMapper;

    @Autowired
    private DownloadHistoryMapper downloadHistoryMapper;

    @Value("${imooc.upload.path.project.material}")
    private String materialPath;

    @ApiOperation(value = "用户上传项目材料", httpMethod = "POST", consumes = "multipart/form-data")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "file", value = "材料文件", dataType = "__file", paramType = "form"),
    })
    @PostMapping("upload")
    public ResultBean<ProjectMaterial> upload(ProjectMaterial projectMaterial, @RequestParam("file") MultipartFile file) {
        ResultBean<ProjectMaterial> resultBean;
        try {
            if (file != null && file.getSize() > 0) {
                String suffix = Objects.requireNonNull(file.getOriginalFilename()).substring(file.getOriginalFilename().lastIndexOf("."));
                ProjectMaterialType types = projectMaterialTypeMapperMapper.selectByPrimaryKey(projectMaterial.getTypeId());
                String[] suffixes = types.getTypeSuffix().split("[,]");
                boolean flag = false;
                for (String s : suffixes) {
                    if (suffix.toLowerCase().endsWith(s)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    resultBean = new ResultBean<>(ResultBean.Code.failure, "文件类型只支持：" + types.getTypeSuffix());
                    return resultBean;
                }
                String newName = UUID.randomUUID().toString() + suffix;
                String materialSavePath = "/static/" + materialPath;
                String parentPath = ResourceUtils.getURL("classpath:").getPath() + materialSavePath;
                File dir = new File(parentPath);
                if (!dir.exists()) {
                    dir.mkdir();
                }
                File newFile = new File(dir, newName);
                file.transferTo(newFile);
                projectMaterial.setMaterialCreateTime(new Date());
                projectMaterial.setMaterialPath(materialPath+newName);
                int rows = mapper.insertSelective(projectMaterial);
                if (rows > 0) {
                    resultBean = new ResultBean<>(ResultBean.Code.success, "上传成功", projectMaterial);
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

    @ApiOperation(value = "项目材料下载")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "项目材料id", dataType = "Integer", paramType = "path")
    })
    @GetMapping("download/{id}")
    public ResponseEntity<Resource> download(@PathVariable("id") Integer id) {
        try {
            ProjectMaterial projectMaterial = mapper.selectByPrimaryKey(id);
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/" + projectMaterial.getMaterialPath();
            Resource resource = new FileUrlResource(path);
            String mimeType = null;
            try {
                mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null == mimeType) {
                mimeType = "application/octet-stream";
            }
            DownloadHistory  downloadHistory=new DownloadHistory();
            downloadHistory.setUserId(getCurrentImoocUser().getId());
            downloadHistory.setProjectId(projectMaterial.getProjectId());
            downloadHistory.setMaterialId(id);
            downloadHistory.setDownloadTime(new Date());
            downloadHistoryMapper.insertSelective(downloadHistory);
            String fileName= URLEncoder.encode(projectMaterial.getMaterialTitle()+path.substring(path.lastIndexOf('.')),"UTF-8");
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(mimeType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + fileName + "\"")
                    .body(resource);
        } catch (FileNotFoundException | MalformedURLException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
