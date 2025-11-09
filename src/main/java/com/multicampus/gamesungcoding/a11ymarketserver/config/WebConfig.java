package com.multicampus.gamesungcoding.a11ymarketserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer cfg) {
        cfg.addPathPrefix("/api",
                HandlerTypePredicate.forBasePackage("com.multicampus.gamesungcoding.a11ymarketserver")
        );
    }
}
