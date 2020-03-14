package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.DownloadHistory;

import java.util.List;
import java.util.Map;

public interface DownloadHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DownloadHistory record);

    int insertSelective(DownloadHistory record);

    DownloadHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DownloadHistory record);

    int updateByPrimaryKey(DownloadHistory record);

    List<Map> selectByUserId(Integer userId);
}