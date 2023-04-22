package com.lc.bbs.service.impl;

import com.lc.bbs.bean.Address;
import com.lc.bbs.dao.AddressDao;
import com.lc.bbs.dao.impl.AddressDaoimpl;
import com.lc.bbs.service.AddressService;

import java.util.List;

/**
 * @Author Lc
 * @Date 2023/4/22
 * @Description
 */
public class AddressServiceimpl implements AddressService {
    private AddressDaoimpl addressDaoimpl = new AddressDaoimpl();

    @Override
    public List<Address> getAddressPage(Integer index, Integer count) {
        String sql = "select * from address limit ?, ?";
        return addressDaoimpl.getAddressPage(sql,index,count);
    }
}
