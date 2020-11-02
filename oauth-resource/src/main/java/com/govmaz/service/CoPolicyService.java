package com.govmaz.service;

import com.github.pagehelper.PageInfo;
import com.govmaz.entity.CoPolicy;

/**
 * 
 *
 * @author jv_team
 * @email 
 * @date 2020-10-17 23:36:08
 */
public interface CoPolicyService {
    CoPolicy save(CoPolicy entity);

    int update(CoPolicy entity);

    int delete(int id);

    CoPolicy selectById(Integer id);

    PageInfo<CoPolicy> selectAllPage(int page, int size);
}