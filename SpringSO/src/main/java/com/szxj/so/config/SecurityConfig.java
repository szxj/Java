package com.szxj.so.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author suzhouxj
 */

//WebSecurityConfigurerAdapter web应用安全适配器
@Configuration
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

    //PasswordEncoder 用什么方式加密
    @Bean
    public PasswordEncoder PasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //表单登录(身份认证)
        http.formLogin()
                .and()
                //请求授权
                .authorizeRequests()
                //任何请求(/user)
                .anyRequest()
                //都需要我们身份认证
                .authenticated();
    }
}
