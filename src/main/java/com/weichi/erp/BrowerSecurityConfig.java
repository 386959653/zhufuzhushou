package com.weichi.erp;

import com.weichi.erp.component.springSecurity.MyAuthenticationProvider;
import com.weichi.erp.component.springSecurity.MyFilterSecurityInterceptor;
import com.weichi.erp.component.springSecurity.MyLoginUrlAuthenticationEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * Created by Wewon on 2018/5/28 9:34
 */
@Configuration
public class BrowerSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyAuthenticationProvider provider;//自定义验证
    @Autowired
    private MyFilterSecurityInterceptor myFilterSecurityInterceptor;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login")           // 设置登录页面
                .permitAll()
                .loginProcessingUrl("/user/login")  // 登录请求拦截的url,也就是form表单提交时指定的action
                .failureForwardUrl("/login?error=error") // 登录失败页面
                .and().exceptionHandling().authenticationEntryPoint(myLoginUrlAuthenticationEntryPoint())//未登录时候跳转页面的处理
                .and()
                .logout()
                .logoutUrl("/logout")
                .and()
                .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
//                .antMatchers("/hello2").permitAll()
//                .antMatchers("/userList").hasAuthority("admin")
                .anyRequest()               // 任何请求
//                .permitAll()               // 都可以访问，需要保护的URL在数据库表里配置
                .authenticated()            // 登录后可以访问
                .and()
                .headers().frameOptions().disable() // 允许网页被iFrame，这样隐性URL才起作用
                .and()
                .csrf().disable();          // 关闭csrf防护
        http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给自定义验证工具
        auth.authenticationProvider(provider);
    }

    @Bean
    public AuthenticationEntryPoint myLoginUrlAuthenticationEntryPoint() {
        return new MyLoginUrlAuthenticationEntryPoint("/login");
    }
}
