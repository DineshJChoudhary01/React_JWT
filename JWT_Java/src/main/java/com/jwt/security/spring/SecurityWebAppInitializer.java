package com.jwt.security.spring;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {
    public SecurityWebAppInitializer(){
        super(SecurityConfig.class);
    }
    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }

}