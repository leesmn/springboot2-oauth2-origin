package com.govmaz.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author: 594781919@qq.com
 * @date: 2018/4/10
 */
@EnableOAuth2Sso
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() //关闭防跨域
            .authorizeRequests()
            .antMatchers("/userinfo").permitAll()
            .antMatchers(HttpMethod.POST,"/login").permitAll()
            .antMatchers(HttpMethod.OPTIONS).permitAll() // 放开权限的url
            .anyRequest()
            .authenticated();//关闭防跨域
    }
}
