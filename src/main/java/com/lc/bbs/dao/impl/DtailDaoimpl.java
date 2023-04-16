package com.lc.bbs.dao.impl;
import java.util.Date;

import com.lc.bbs.bean.Detail;
import com.lc.bbs.dao.DetailDao;
import com.lc.bbs.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description
 */
public class DtailDaoimpl implements DetailDao {
    @Override
    public List<Detail> selectDetailListByCondition(Integer sortId) {
        //查询论坛版区的sql语句
        String sql = "select id,sort_id,title,detail,author,create_date,reply_count from bbs_detail";

        Object [] params = new Object[]{};
        //动态条件查询
        if(null != sortId && 0 != sortId){
            sql += " where sort_id = ?";
            params = new Object[]{sortId};
        }
        ArrayList<Detail> detailsArrayList = new ArrayList<>();
        //执行查询，获取结果
        try {
            ResultSet resultSet = JDBCUtil.executeSelect(sql, params);

            //解析查询结果
            while (resultSet.next()){
                //创建论坛帖子对象
                Detail detail = new Detail();
                detail.setId(resultSet.getInt(1));
                detail.setSortId(resultSet.getInt(2));
                detail.setTitle(resultSet.getString(3));
                detail.setDetail(resultSet.getString(4));
                detail.setAuthor(resultSet.getString(5));
                detail.setCreateDate(new Date());
                detail.setReplyCount(resultSet.getInt(7));
                detailsArrayList.add(detail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return detailsArrayList;
    }

    @Override
    public int insertDetail(Detail detailForm) {
        // 插入帖子详情SQL语句
        String executeSql = "insert into bbs_detail(sort_id, title, detail, author, create_date, reply_count) values (?, ?, ?, ?, now(), ?)";

        // 插入帖子详情参数
        Object[] params = {detailForm.getSortId(), detailForm.getTitle(), detailForm.getDetail(), detailForm.getAuthor(), 1};

        // 执行插入帖子详情
        return JDBCUtil.executeUpate(executeSql, params);
    }
}
