package com.lc.bbs.dao.impl;

import com.lc.bbs.bean.Sort;
import com.lc.bbs.dao.SortDao;
import com.lc.bbs.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description 论坛版区实现类
 */
public class SortDaoimpl implements SortDao {
    @Override
    public List<Sort> selectSortList() {
        //查询论坛版区的sql语句
        String sql = "select id,name from bbs_sort";

        Object [] params = {};
        ArrayList<Sort> sortArrayList = new ArrayList<>();
        //执行查询，获取结果
        try {
            ResultSet resultSet = JDBCUtil.executeSelect(sql,params);
            //解析查询结果
            while (resultSet.next()){
                //创建版区对象
                Sort sort = new Sort();
                sort.setId(resultSet.getInt(1));
                sort.setName(resultSet.getString(2));
                sortArrayList.add(sort);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sortArrayList;
    }
}
