package com.lc.bbs.service;

import com.lc.bbs.bean.Sort;

import java.util.List;

/**
 * 论坛版区
 */
public interface SortService {
    /**
     * 获取所有的列盘版区
     * @return
     */
    List<Sort> getAllSortList();
}
