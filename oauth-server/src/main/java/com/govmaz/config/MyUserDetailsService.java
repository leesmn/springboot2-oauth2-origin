package com.govmaz.config;

import com.govmaz.utils.RestUtil;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @author: 594781919@qq.com
 * @Date: 2018/4/8 15:26
 * @version: 1.0
 */
@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 这个地方可以通过username从数据库获取正确的用户信息，包括密码和权限等。
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new MyGrantedAuthority("MY_ROLE1", "MY_MENU1"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        Map<String,Object> param = new HashMap<>();
        param.put("username",username);
        Map<String,Object> result = (Map<String,Object>)RestUtil.requestApi("http://127.0.0.1:8826/userinfo?username={username}",param,restTemplate);
        if(!result.get("code").equals(200)){
            throw new UsernameNotFoundException("用户不存在");
        }else{
            return new User(username, "{noop}"+result.get("data").toString(), grantedAuthorityList);
        }


    }
}
