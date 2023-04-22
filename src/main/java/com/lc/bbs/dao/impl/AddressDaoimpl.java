package com.lc.bbs.dao.impl;

import com.lc.bbs.bean.Address;
import com.lc.bbs.util.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/4/22
 * @Description
 */
public class AddressDaoimpl extends BaseDao<Address> {
    public AddressDaoimpl() {
        this.setT(new Address());
    }
    //查询用户前10条
    public List<Address> getAddressPage(String sql,Integer index,Integer count){
        List<Address> addressList = new ArrayList<>();
        try {
            initConnection();
            ResultSet resultSet = selectPage(sql, index,count);
            while (resultSet.next()){
                Address address = new Address();
                address.setAddress_areaId(resultSet.getString("address_areaId"));
                address.setAddress_name(resultSet.getString("address_name"));
                address.setAddress_regionId(resultSet.getString("address_regionId"));
                addressList.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addressList;
    }

    public static void main(String[] args) {
        AddressDaoimpl addressDaoimpl = new AddressDaoimpl();
        String sql ="select * from address limit ?,?";
        List<Address> addressPage = addressDaoimpl.getAddressPage(sql,0,20);
        addressPage.forEach(address -> {
            System.out.println(address.getAddress_name());
        });
    }
}
