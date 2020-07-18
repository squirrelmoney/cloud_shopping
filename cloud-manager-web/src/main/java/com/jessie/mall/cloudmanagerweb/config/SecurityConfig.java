package com.jessie.mall.cloudmanagerweb.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @description:
 * @author: money
 * @time: 2020/7/14 9:21
 */
/**
 * EnableWebSecurity注解使得SpringMVC集成了Spring Security的web安全支持
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//        @Resource
//        private MyUserDetailService myUserDetailService;

        /**
         * 权限配置
         */
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // 配置拦截规则
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/page1/**").hasRole("LEVEL1")
//                .antMatchers("/page2/**").hasRole("LEVEL2")
//                .antMatchers("/page3/**").hasRole("LEVEL3");
            http.authorizeRequests()
                    .antMatchers("/login.html").permitAll()
                    .antMatchers("/css/**","/img/**","/js/**","/plugins/**").permitAll()
                    .antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
                    .and().headers().frameOptions().disable()
                    .and().formLogin().loginPage("/login.html").defaultSuccessUrl("/admin/index.html")
                    .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login.html")
                    .and().csrf().disable();
            // 配置登录功能
//        http.formLogin().usernameParameter("user")
//                .passwordParameter("pwd")
//                .loginPage("/addshow");
//        // 注销成功跳转首页
//        http.logout().logoutSuccessUrl("/");
//        //开启记住我功能
//        http.rememberMe().rememberMeParameter("remeber");
        }
//
        /**
         * 密码加密
         */
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public  static NoOpPasswordEncoder passwordEncoder(){
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
        /*
         * 硬编码几个用户

         */
        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("spring").password("123456").roles("LEVEL1","LEVEL2")
//                .and()
//                .withUser("summer").password("123456").roles("LEVEL2","LEVEL3")
//                .and()
//                .withUser("autumn").password("123456").roles("LEVEL1","LEVEL3");
       auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("admin").password(new BCryptPasswordEncoder().encode("123")).authorities("ROLE_ADMIN");
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("user").password(new BCryptPasswordEncoder().encode("123")).authorities("ROLE_USER");

//            auth.userDetailsService(myUserDetailService).passwordEncoder(new PasswordEncoder() {
//                //对表单进行加密
//                @Override
//                public String encode(CharSequence rawPassword) {
//                    System.out.println("====表单password===="+MD5Util.encode(rawPassword.toString()));
//                    return MD5Util.encode(rawPassword.toString());
//                }
//
//                //加密的密码与数据库密码进行比较
//                //rowpassword：表单密码
//                //encodePassword：数据库密码
//                @Override
//                public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                    System.out.println("====数据库password===="+encodedPassword);
//                    System.out.println("====表单password===="+rawPassword);
//                    System.out.println("====表单password===="+MD5Util.encode(rawPassword.toString()));
//                    return MD5Util.encode(rawPassword.toString()).equals(encodedPassword);
//                }
//            });
        }

    }

