package com.govmaz.config;

import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * 资源服务器
 * 配置了@EnableResourceServer ，所有发往nb-order-api的请求，都会去请求头里找token，找不到不让你过
 */
@Configuration
@EnableResourceServer//告诉nb-order-api,你就是资源服务器
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private final ResourceServerProperties resource;

    public String getTokenInfoUri(){
        return this.resource.getTokenInfoUri();
    }

    public String getClientId(){
        return this.resource.getClientId();
    }
    public String getClientSecret(){
        return this.resource.getClientSecret();
    }


    public OAuth2ResourceServerConfig(ResourceServerProperties resource) {
        this.resource = resource;
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        //配置资源服务器的id，“现在我就是资源服务器order-server！！！”
        resources.resourceId(this.resource.getResourceId());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        /**
         * 进入nb-order-api的所有请求，哪些要拦截，哪些要放过，在这里配置
         */
        http.authorizeRequests()
                .antMatchers("/login/**","/userinfo/**")
                .permitAll() //放过/haha不拦截
                .antMatchers("/swagger**/**","/webjars/**","/swagger-ui.html","/doc.html","/v2/**")
                .permitAll()
                .anyRequest().authenticated();//其余所有请求都拦截

//        http.authorizeRequests()
//            .antMatchers("/user/token","/client/token").permitAll().anyRequest().authenticated();
    }
}
