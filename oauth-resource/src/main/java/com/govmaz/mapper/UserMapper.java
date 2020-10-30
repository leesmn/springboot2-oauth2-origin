package com.govmaz.mapper;


import com.govmaz.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


/**
 * 
 * 
 * @author jv_team
 * @email 
 * @date 2020-06-15 12:52:01
 */
@Mapper
public interface UserMapper {
    int save(User entity);

    int update(User entity);

    int delete(int id);

    User selectByName(@Param("username") String username);
}
