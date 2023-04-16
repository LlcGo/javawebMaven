package com.lc.bbs.service.impl;

import com.lc.bbs.bean.Sort;
import com.lc.bbs.dao.SortDao;
import com.lc.bbs.dao.impl.SortDaoimpl;
import com.lc.bbs.service.SortService;

import java.util.List;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description
 */
public class SortServiceimpl implements SortService {
    private SortDao sortDao = new SortDaoimpl();
    @Override
    public List<Sort> getAllSortList() {
        return sortDao.selectSortList();
    }
}
