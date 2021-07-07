package com.leoncio.clientbrasilprev.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//@Profile("test")
@Configuration
public class TestSecurity extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity web) throws Exception {
        web
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}
