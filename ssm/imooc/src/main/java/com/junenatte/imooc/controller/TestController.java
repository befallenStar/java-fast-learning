package com.junenatte.imooc.controller;

import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.Api;

@Api(value = "下载测试", tags = "下载测试")
@RestController
public class TestController {
    @GetMapping("download")
    public ResponseEntity<Resource> download(String url, HttpServletRequest request) {
        try {
            String path = ResourceUtils.getURL("classpath:").getPath() + "static/" + url;
            Resource resource = new FileUrlResource(path);
            String mediaType = null;
            try {
                mediaType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (null == mediaType) {
                mediaType = "application/octet-stream";
            }
            return ResponseEntity.ok().contentType(MediaType.parseMediaType(mediaType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
