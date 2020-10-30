package com.govmaz.service;


import com.govmaz.entity.User;

/**
 * 
 *
 * @author jv_team
 * @email 
 * @date 2020-06-15 12:52:01
 */
public interface UserService  {
    User save(User entity);

    int update(User entity);

    int delete(int id);

    User selectByName(String username);
}