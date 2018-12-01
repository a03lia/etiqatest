/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a03lia.university.frontend.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author a03lia
 */
@Configuration
@EnableAutoConfiguration
public class WebConfig implements WebMvcConfigurer
{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler(
                "/bower_components/**",
                "/node_modules/**",
                "/webjars/**")
                .addResourceLocations(
                        "classpath:/static/bower_components/",
                        "classpath:/static/node_modules/",
                        "/webjars/");
    }
}
