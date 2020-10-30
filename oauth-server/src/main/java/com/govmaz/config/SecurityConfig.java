package com.govmaz.config;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Description:
 * @author: 594781919@qq.com
 * @Date: 2018/4/8 10:46
 * @version: 1.0
 */
@Configuration
@EnableWebSecurity //使安全配置生效
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Qualifier("myUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/**/*.js",
//                        "/**/*.css","/token","/oauth/**"
//                )
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                // 自动登录
//                /*.and()
//                    .rememberMe()
//                    // 加密的秘钥
//                    .key("unique-and-secret")
//                    // 存放在浏览器端cookie的key
//                    .rememberMeCookieName("remember-me-cookie-name")
//                    // token失效的时间，单位为秒
//                    .tokenValiditySeconds(60 * 60 * 25)*/
//                .and()
//                // 暂时禁用CSRF，否则无法提交登录表单
//                .csrf().disable();
//
//        http.requestMatchers().antMatchers("/oauth/**")
//            .and()
//            .authorizeRequests()
//            .antMatchers("/oauth/**").authenticated();

        http.authorizeRequests()
            .antMatchers("/login")
            .permitAll()
//            .antMatchers("/**/*.js", "/**/*.css")
//            .permitAll()
            .antMatchers(HttpMethod.POST,"/oauth/**").permitAll()
            .antMatchers(HttpMethod.OPTIONS).permitAll() // 放开权限的url
            .anyRequest()
            .authenticated()
            .and().exceptionHandling()
            .authenticationEntryPoint(
                (request, response, authException) -> {
                    response.setContentType("application/json;charset=utf-8");
                    PrintWriter out = response.getWriter();
                    Map<String,Object> respResult = new HashMap();
                    respResult.put("code",401);
                    respResult.put("message","无权限");
                    out.write(new ObjectMapper().writeValueAsString(respResult));
                    out.flush();
                    out.close();
                }
            ).and()
            .csrf().disable();

    }

}
