package com.govmaz.mapper;


import com.govmaz.entity.ChinaAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ChinaAddressMapper {
    List<ChinaAddress> queryChinaAddress(@Param("myColums") String myColums, @Param("parentId") String parentId);
    String getAddressName(@Param("id") String id);
}