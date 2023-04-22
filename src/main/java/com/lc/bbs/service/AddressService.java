package com.lc.bbs.service;

import com.lc.bbs.bean.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressPage(Integer index,Integer count);
}
