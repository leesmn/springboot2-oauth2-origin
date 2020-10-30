package com.govmaz.service;



import com.govmaz.entity.ChinaAddress;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/06/14.
 */
public interface ChinaAddressService {
    List<ChinaAddress> queryChinaAddress(String myColums, String parentId);
    String getAddressName(String id);
}
