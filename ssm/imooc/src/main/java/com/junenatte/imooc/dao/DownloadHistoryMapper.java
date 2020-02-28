package com.junenatte.imooc.dao;

import com.junenatte.imooc.bean.DownloadHistory;

public interface DownloadHistoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DownloadHistory record);

    int insertSelective(DownloadHistory record);

    DownloadHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DownloadHistory record);

    int updateByPrimaryKey(DownloadHistory record);
}