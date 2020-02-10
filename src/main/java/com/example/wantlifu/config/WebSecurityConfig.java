package com.example.wantlifu.config;




import com.example.wantlifu.entity.Admin;
import com.example.wantlifu.entity.User;
import com.example.wantlifu.service.impl.AdminService;
import com.example.wantlifu.service.impl.UserService;
import com.example.wantlifu.service.security.JwtAuthenticationTokenFilter;
import com.example.wantlifu.service.security.RestAuthenticationEntryPoint;
import com.example.wantlifu.service.security.RestfulAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)  //开启 全局的 security授权
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AdminService adminService;
    @Autowired
    UserService userService;
    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;
    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()// 由于使用的是JWT，我们这里不需要csrf
                .disable()
                .sessionManagement()// 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js"
                )
                .permitAll()
                .antMatchers("/user/findBack","/user/loginPage","/user/login", "/user/register","/admin/login","/admin/loginPage")// 对登录注册要允许匿名访问
                .permitAll()
                .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
                .permitAll()
                .antMatchers("/**")//测试时全部运行访问
                .permitAll()
//                .antMatchers("/user/**","/dashboard/**")// 除上面外的所有请求全部需要鉴权认证
//                .hasAnyRole("user","admin","company")
//                .antMatchers("/admin/**")// 除上面外的所有请求全部需要鉴权认证
//                .hasAnyRole("admin")
                .anyRequest()
                .permitAll();
        // 禁用缓存
        httpSecurity.headers().cacheControl();
        // 添加JWT filter
        //允许 frame
        httpSecurity.headers().frameOptions().sameOrigin();
        httpSecurity.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//        httpSecurity.addFilterBefore(myTypeFilter(), JwtAuthenticationTokenFilter.class);
        //添加自定义未授权和未登录结果返回
        httpSecurity.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService adminDetailService() {

        return username -> {
            Admin admin = adminService.loadAdminByName(username);
            if (admin != null) {
                return admin;
            }
            throw new UsernameNotFoundException("用户名不存在！");
        };
    }
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            User users = userService.loadUserByName(username);
            if (users != null) {
                return users;
            }
            throw new UsernameNotFoundException("用户名不存在！");
        };
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter(){
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

}
