package cn.edu.njnu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.edu.njnu.bean.Resource;
import cn.edu.njnu.dao.ResourceMapper;

@Service
public class ResourceService {
    @Autowired
    private ResourceMapper resourceMapper;

    public void uploadFile(Resource resource) {
        resourceMapper.insertSelective(resource);
    }

    public List<Resource> selectByCourseId(Integer courseId) {
        return resourceMapper.selectByCourseId(courseId);
    }

    public int deleteById(Integer id) {
        return resourceMapper.deleteByPrimaryKey(id);
    }

    public Resource queryById(Integer id) {
        return resourceMapper.selectByPrimaryKey(id);
    }

}
