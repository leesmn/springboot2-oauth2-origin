package com.govmaz.service.impl;


import com.govmaz.entity.ChinaAddress;
import com.govmaz.mapper.ChinaAddressMapper;
import com.govmaz.service.ChinaAddressService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
@Service
@Transactional
public class ChinaAddressServiceImpl implements ChinaAddressService {
    @Resource
    private ChinaAddressMapper chinaAddressMapper;


    @Override
    public List<ChinaAddress> queryChinaAddress(String myColums, String parentId) {
        return chinaAddressMapper.queryChinaAddress(myColums,parentId);
    }

    @Override
    public String getAddressName(String id) {
        return chinaAddressMapper.getAddressName(id);
    }
}
