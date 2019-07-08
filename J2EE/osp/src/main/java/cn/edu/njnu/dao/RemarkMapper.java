package cn.edu.njnu.dao;

import java.util.List;

import cn.edu.njnu.bean.Remark;

public interface RemarkMapper {
    int insert(Remark record);

    int insertSelective(Remark record);

    List<Remark> query();
}