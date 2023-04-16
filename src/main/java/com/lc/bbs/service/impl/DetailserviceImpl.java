package com.lc.bbs.service.impl;

import com.lc.bbs.bean.Detail;
import com.lc.bbs.dao.DetailDao;
import com.lc.bbs.dao.impl.DtailDaoimpl;
import com.lc.bbs.service.DetailService;

import java.util.List;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description
 */
public class DetailserviceImpl implements DetailService {

    private DetailDao detailDao = new DtailDaoimpl();

    @Override
    public List<Detail> getDetailListById(Integer sortId) {
        return detailDao.selectDetailListByCondition(sortId);
    }

    @Override
    public void addDetail(Detail detailForm) {
        detailDao.insertDetail(detailForm);
    }
}
