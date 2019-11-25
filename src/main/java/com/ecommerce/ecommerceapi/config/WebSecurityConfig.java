package com.ecommerce.ecommerceapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("admin").password("password").roles("USER", "ADMIN");

    }
    // Secure the endpoins with HTTP Basic authentication
   @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
       //HTTP Basic authentication
               .httpBasic()
               .and()
               .csrf().disable()
               .headers().frameOptions().disable()
               .and()
              /* .authorizeRequests()
               .antMatchers(HttpMethod.POST, "/product").hasRole("ADMIN")
               .antMatchers("/").permitAll().and()*/
               .authorizeRequests().antMatchers("/console/**").permitAll()
               .and()
               .csrf().disable()
               .formLogin().disable();
          }

}
