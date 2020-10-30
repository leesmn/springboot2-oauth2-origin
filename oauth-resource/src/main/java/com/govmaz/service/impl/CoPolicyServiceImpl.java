package com.govmaz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.govmaz.entity.CoPolicy;
import com.govmaz.mapper.CoPolicyMapper;
import com.govmaz.service.CoPolicyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author jv_team
 * @email 
 * @date 2020-10-17 23:36:08
 */
@Service
public class CoPolicyServiceImpl implements CoPolicyService {
    @Autowired
    CoPolicyMapper instCoPolicyMapper;

    @Override
    public CoPolicy save(CoPolicy entity) {
        instCoPolicyMapper.save(entity);
        return entity;
    }

    @Override
    public int update(CoPolicy entity) {
        return instCoPolicyMapper.update(entity);
    }

    @Override
    public int delete(int id) {
        return instCoPolicyMapper.delete(id);
    }

    @Override
    public PageInfo<CoPolicy> selectAllPage(int page,int size) {
        PageHelper.startPage(page,size);
        List<CoPolicy> pageResult = instCoPolicyMapper.selectAll();
        PageInfo<CoPolicy> reslut = new PageInfo(pageResult);
        return reslut;
    }
}