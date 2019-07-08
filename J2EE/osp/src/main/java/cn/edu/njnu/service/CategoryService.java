package cn.edu.njnu.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import cn.edu.njnu.bean.Category;
import cn.edu.njnu.dao.CategoryMapper;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public Category queryById(Integer categoryId) {
        return categoryMapper.selectByPrimaryKey(categoryId);
    }

    public List<Category> queryAll() {
        return categoryMapper.queryAll();
    }


    public int deleteById(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    public int updateSelective(Category category) {
        return categoryMapper.updateSelective(category);
    }

    public int insertCategory(Category category1) {
        return categoryMapper.insertSelective(category1);
    }
}
