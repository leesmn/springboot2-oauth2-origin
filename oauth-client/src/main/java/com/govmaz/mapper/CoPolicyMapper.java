package com.govmaz.mapper;

import com.govmaz.entity.CoPolicy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 
 * 
 * @author jv_team
 * @email 
 * @date 2020-10-17 23:36:08
 */
@Mapper
public interface CoPolicyMapper {
    int save(CoPolicy entity);

    int update(CoPolicy entity);

    int delete(int id);

    List<CoPolicy> selectAll();
}
