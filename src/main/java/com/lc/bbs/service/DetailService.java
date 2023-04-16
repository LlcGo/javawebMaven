package com.lc.bbs.service;

import com.lc.bbs.bean.Detail;

import java.util.List;

public interface DetailService {
    /**
     * 根据id查询论坛帖子
     * @param sortId 帖子id
     * @return 所有的列表
     */
    List<Detail> getDetailListById(Integer sortId);

    void addDetail(Detail detailForm);
}
