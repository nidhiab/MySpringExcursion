package com.nb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(SecurityConfig.class);
    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        logger.info("SecurityConfig::configAuthentication");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery(
                        "select username, role from user_roles where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.info("SecurityConfig::configure");
        http.authorizeRequests()
                .antMatchers("/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("views/j_spring_security_check")
                .defaultSuccessUrl("/WEB-INF/hello.jsp")
                .failureUrl("/login?error")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .csrf();
    }

   // @Override
    /*protected void configure1(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login","/login/form**","/register","/logout").permitAll()
                .antMatchers("/admin","/admin*//**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login/form")
                .loginProcessingUrl("/login")
                .failureUrl("/login/form?error")
                .permitAll();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        logger.info("SecurityConfig::configure");
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(
                        "select username, password, true " +
                        "from Spitter where username=?")
                .authoritiesByUsernameQuery(
                        "select username, 'ROLE_USER' from Spitter where username=?");
    }*/
}
