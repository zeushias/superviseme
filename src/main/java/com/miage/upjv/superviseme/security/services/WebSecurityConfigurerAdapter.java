package com.miage.upjv.superviseme.security.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfigurerAdapter {

    public static final String CUSTOM_AUTHORIZATION_HEADER = "X-JWT-Assertion";


}
