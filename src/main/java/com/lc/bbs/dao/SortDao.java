package com.lc.bbs.dao;

import com.lc.bbs.bean.Sort;

import java.util.List;

/**
 * 论坛版区持久层接口
 */
public interface SortDao {
    /**
     * 查询所有的讨论版区
     * @return
     */
    List<Sort> selectSortList();
}
