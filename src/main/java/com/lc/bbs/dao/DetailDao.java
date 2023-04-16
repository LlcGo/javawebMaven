package com.lc.bbs.dao;

import com.lc.bbs.bean.Detail;

import java.util.List;

public interface DetailDao {
    /**
     * 根据版区编号查询帖子列表
     * @return
     */
    List<Detail> selectDetailListByCondition(Integer sortId);

    int insertDetail(Detail detailForm);
}
