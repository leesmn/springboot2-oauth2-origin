package com.govmaz.service.impl;

import com.govmaz.entity.User;
import com.govmaz.mapper.UserMapper;
import com.govmaz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 *
 * @author jv_team
 * @email 
 * @date 2020-06-15 12:52:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper instUserMapper;

    @Override
    public User save(User entity) {
        instUserMapper.save(entity);
        return entity;
    }

    @Override
    public int update(User entity) {
        return instUserMapper.update(entity);
    }

    @Override
    public int delete(int id) {
        return instUserMapper.delete(id);
    }

    @Override
    public User selectByName(String username) {
        return instUserMapper.selectByName(username);
    }
}